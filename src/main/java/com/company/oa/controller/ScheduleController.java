package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.dto.ScheduleDTO;
import com.company.oa.entity.SysSchedule;
import com.company.oa.service.SysScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    private SysScheduleService svc;

    @GetMapping
    public R<Page<SysSchedule>> page(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required=false) Long userId
    ) {
        return R.ok(svc.pageSchedules(page,size,userId));
    }

    @PostMapping
    public R<Void> create(@RequestBody ScheduleDTO dto) {
        svc.createSchedule(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(
            @PathVariable Long id,
            @RequestBody ScheduleDTO dto
    ) {
        svc.updateSchedule(id,dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deleteSchedule(id);
        return R.ok();
    }
}