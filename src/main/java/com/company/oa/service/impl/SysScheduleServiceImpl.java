package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.dto.ScheduleDTO;
import com.company.oa.entity.SysSchedule;
import com.company.oa.mapper.SysScheduleMapper;
import com.company.oa.service.SysScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SysScheduleServiceImpl extends ServiceImpl<SysScheduleMapper, SysSchedule> implements SysScheduleService {
    @Autowired
    private SysScheduleMapper scheduleMapper;

    @Override
    public Page<SysSchedule> pageSchedules(int page, int size, Long userId) {
        return scheduleMapper.selectPage(new Page<>(page,size),
                Wrappers.<SysSchedule>lambdaQuery()
                        .eq(userId!=null, SysSchedule::getUserId, userId)
                        .orderByAsc(SysSchedule::getWorkDate));
    }

    @Override
    public void createSchedule(ScheduleDTO dto) {
        SysSchedule e = new SysSchedule();
        BeanUtils.copyProperties(dto, e);
        e.setCreatedTime(LocalDateTime.now());
        scheduleMapper.insert(e);
    }

    @Override
    public void updateSchedule(Long id, ScheduleDTO dto) {
        SysSchedule e = new SysSchedule();
        BeanUtils.copyProperties(dto, e);
        e.setId(id);
        e.setUpdatedTime(LocalDateTime.now());
        scheduleMapper.updateById(e);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleMapper.deleteById(id);
    }
}