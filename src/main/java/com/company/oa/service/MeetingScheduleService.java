package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.entity.MeetingSchedule;

public interface MeetingScheduleService extends IService<MeetingSchedule> {
    Page<MeetingSchedule> pageByUser(Long userId, int page, int size);
    void createSchedule(MeetingSchedule schedule);
    void deleteSchedule(Long id);
}