package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.entity.SysAttendance;
import com.company.oa.mapper.SysAttandenceMapper;
import com.company.oa.service.SysAttandenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SysAttandenceServiceImpl extends ServiceImpl<SysAttandenceMapper, SysAttendance> implements SysAttandenceService {

    @Autowired
    private SysAttandenceMapper attendanceMapper;

    @Override
    public Page<SysAttendance> pageAttendance(int page, int size, Long userId) {
        return attendanceMapper.selectPage(new Page<>(page,size),
                Wrappers.<SysAttendance>lambdaQuery()
                        .eq(userId!=null, SysAttendance::getUserId, userId)
                        .orderByDesc(SysAttendance::getClockDate));
    }

    @Override
    public void clockIn(Long userId) {
        SysAttendance a = new SysAttendance();
        a.setUserId(userId);
        a.setClockDate(LocalDate.now());
        a.setClockInTime(LocalDateTime.now());
        a.setStatus(0);
        attendanceMapper.insert(a);
    }
    @Override
    public void clockOut(Long userId) {
        LambdaUpdateWrapper<SysAttendance> upd = Wrappers.lambdaUpdate(SysAttendance.class)
                .set(SysAttendance::getClockOutTime, LocalDateTime.now())
                .eq(SysAttendance::getUserId, userId)
                .eq(SysAttendance::getClockDate, LocalDate.now());
        attendanceMapper.update(null, upd);
    }
}
