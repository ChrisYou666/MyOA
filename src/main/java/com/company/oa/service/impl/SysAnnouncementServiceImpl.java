// src/main/java/com/company/oa/service/impl/SysAnnouncementServiceImpl.java
package com.company.oa.service.impl;

import com.company.oa.entity.SysAnnouncement;
import com.company.oa.entity.SysNotification;
import com.company.oa.dto.SysAnnouncementDTO;
import com.company.oa.vo.SysAnnouncementVO;
import com.company.oa.mapper.SysAnnouncementMapper;
import com.company.oa.mapper.SysNotificationMapper;
import com.company.oa.service.SysAnnouncementService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysAnnouncementServiceImpl
        extends ServiceImpl<SysAnnouncementMapper, SysAnnouncement>
        implements SysAnnouncementService {

    private final SysNotificationMapper notificationMapper;

    public SysAnnouncementServiceImpl(SysNotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Page<SysAnnouncementVO> pageAnnouncements(int page, int size) {
        Page<SysAnnouncement> pe = this.page(new Page<>(page, size));
        Page<SysAnnouncementVO> po = new Page<>(pe.getCurrent(), pe.getSize(), pe.getTotal());
        pe.getRecords().forEach(ent -> {
            SysAnnouncementVO vo = new SysAnnouncementVO();
            BeanUtils.copyProperties(ent, vo);
            po.getRecords().add(vo);
        });
        return po;
    }

    @Override
    public SysAnnouncementVO getAnnouncement(Long id) {
        SysAnnouncement ent = this.getById(id);
        SysAnnouncementVO vo = new SysAnnouncementVO();
        BeanUtils.copyProperties(ent, vo);
        return vo;
    }

    @Override
    public void createAnnouncement(SysAnnouncementDTO dto) {
        SysAnnouncement ent = new SysAnnouncement();
        BeanUtils.copyProperties(dto, ent);
        ent.setCreatedTime(LocalDateTime.now());
        ent.setUpdatedTime(LocalDateTime.now());
        this.save(ent);
    }

    @Override
    public void updateAnnouncement(Long id, SysAnnouncementDTO dto) {
        SysAnnouncement ent = new SysAnnouncement();
        BeanUtils.copyProperties(dto, ent);
        ent.setId(id);
        ent.setUpdatedTime(LocalDateTime.now());
        this.updateById(ent);
    }

    @Override
    public void deleteAnnouncement(Long id) {
        this.removeById(id);
    }

    @Override
    public List<SysNotification> sendNotification(Long announcementId, List<Long> userIds) {
        List<SysNotification> list = userIds.stream().map(uid -> {
            SysNotification n = new SysNotification();
            n.setAnnouncementId(announcementId);
            n.setReceiverId(uid);
            n.setStatus(0);
            n.setSentTime(LocalDateTime.now());
            notificationMapper.insert(n);
            return n;
        }).collect(Collectors.toList());
        return list;
    }
}