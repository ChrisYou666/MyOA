package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.entity.*;
import com.company.oa.service.*;
import io.micrometer.core.instrument.Meter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class CustomReportController {
    @Autowired private CustomReportService svc;

    @GetMapping
    public R<Page<CustomReport>> page(@RequestParam int page, @RequestParam int size) {
        return R.ok(svc.pageReports(page, size));
    }

    @PostMapping
    public R<Void> create(@RequestBody CustomReport rpt) {
        svc.createReport(rpt);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody CustomReport rpt) {
        svc.updateReport(id, rpt);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deleteReport(id);
        return R.ok();
    }

    @GetMapping("/{id}/run")
    public R<List<Map<String,Object>>> run(@PathVariable Long id) {
        return R.ok(svc.runReport(id));
    }
}