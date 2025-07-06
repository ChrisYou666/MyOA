// src/main/java/com/company/oa/service/impl/SysNotificationServiceImpl.java
package com.company.oa.service.impl;

import com.company.oa.dto.SysNotificationDTO;
import com.company.oa.entity.SysNotification;
import com.company.oa.mapper.SysNotificationMapper;
import com.company.oa.service.SysNotificationService;
import com.company.oa.vo.SysNotificationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysNotificationServiceImpl implements SysNotificationService {

    private final SysNotificationMapper mapper;

    public SysNotificationServiceImpl(SysNotificationMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Page<SysNotificationVO> pageNotifications(int page, int size, Long receiverId) {
        Page<SysNotification> pe = mapper.selectPage(
                new Page<>(page, size),
                // 构造 receiver_id 查询
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<SysNotification>()
                        .eq("receiver_id", receiverId)
        );
        Page<SysNotificationVO> voPage = new Page<>(pe.getCurrent(), pe.getSize(), pe.getTotal());
        List<SysNotificationVO> vos = pe.getRecords().stream().map(e -> {
            SysNotificationVO vo = new SysNotificationVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toList());
        voPage.setRecords(vos);
        return voPage;
    }

    @Override
    public SysNotificationVO getNotification(Long id) {
        SysNotification e = mapper.selectById(id);
        SysNotificationVO vo = new SysNotificationVO();
        BeanUtils.copyProperties(e, vo);
        return vo;
    }

    @Override
    public void createNotification(SysNotificationDTO dto) {
        SysNotification e = new SysNotification();
        BeanUtils.copyProperties(dto, e);
        e.setSentTime(dto.getSentTime() != null ? dto.getSentTime() : LocalDateTime.now());
        mapper.insert(e);
    }

    @Override
    public void updateNotification(Long id, SysNotificationDTO dto) {
        SysNotification e = new SysNotification();
        BeanUtils.copyProperties(dto, e);
        e.setId(id);
        mapper.updateById(e);
    }

    @Override
    public void deleteNotification(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public void markAsRead(Long id) {
        SysNotification e = new SysNotification();
        e.setId(id);
        e.setStatus(1);
        mapper.updateById(e);
    }

    @Override
    public List<SysNotificationVO> listByReceiver(Long receiverId) {
        return mapper.selectList(
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<SysNotification>()
                        .eq("receiver_id", receiverId)
        ).stream().map(e -> {
            SysNotificationVO vo = new SysNotificationVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toList());
    }
}