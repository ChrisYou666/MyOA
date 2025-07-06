package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.entity.*;
import com.company.oa.mapper.*;
import com.company.oa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingScheduleServiceImpl extends ServiceImpl<MeetingScheduleMapper,MeetingSchedule> implements MeetingScheduleService {
    @Autowired private MeetingScheduleMapper mapper;

    @Override
    public Page<MeetingSchedule> pageByUser(Long userId, int page, int size) {
        return mapper.selectPage(
                new Page<>(page, size),
                new QueryWrapper<MeetingSchedule>().eq("user_id", userId)
        );
    }

    @Override public void createSchedule(MeetingSchedule schedule) {
        mapper.insert(schedule);
    }

    @Override public void deleteSchedule(Long id) {
        mapper.deleteById(id);
    }
}