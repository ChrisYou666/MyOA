package com.company.oa.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.ScheduleDTO;
import com.company.oa.entity.SysSchedule;
import org.apache.ibatis.annotations.Mapper;

public interface SysScheduleService extends IService<SysSchedule> {
    Page<SysSchedule> pageSchedules(int page, int size, Long userId);
    void createSchedule(ScheduleDTO dto);
    void updateSchedule(Long id, ScheduleDTO dto);
    void deleteSchedule(Long id);
}