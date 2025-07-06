package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.entity.SysAttendance;
import com.company.oa.service.SysAttandenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttandenceController {

    @Autowired
    private SysAttandenceService svc;

    @GetMapping
    public R<Page<SysAttendance>> page(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required=false) Long userId
    ) {
        return R.ok(svc.pageAttendance(page,size,userId));
    }

    @PostMapping("/clock-in")
    public R<Void> clockIn(@RequestParam Long userId) {
        svc.clockIn(userId);
        return R.ok();
    }

    @PostMapping("/clock-out")
    public R<Void> clockOut(@RequestParam Long userId) {
        svc.clockOut(userId);
        return R.ok();
    }
}