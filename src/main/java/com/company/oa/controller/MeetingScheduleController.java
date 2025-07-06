package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.entity.*;
import com.company.oa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/meeting-schedules")
public class MeetingScheduleController {
    @Autowired private MeetingScheduleService svc;

    @GetMapping("/user/{userId}")
    public R<Page<MeetingSchedule>> pageByUser(
            @PathVariable Long userId,
            @RequestParam int page,
            @RequestParam int size) {
        return R.ok(svc.pageByUser(userId, page, size));
    }

    @PostMapping
    public R<Void> create(@RequestBody @Valid MeetingSchedule schedule) {
        svc.createSchedule(schedule);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deleteSchedule(id);
        return R.ok();
    }
}