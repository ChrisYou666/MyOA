package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.entity.SysAttendance;

public interface SysAttandenceService extends IService<SysAttendance> {
    Page<SysAttendance> pageAttendance(int page, int size, Long userId);
    void clockIn(Long userId);
    void clockOut(Long userId);
}