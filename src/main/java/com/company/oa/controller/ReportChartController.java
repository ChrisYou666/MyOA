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
@RequestMapping("/api/report-charts")
public class ReportChartController {
    @Autowired private ReportChartService svc;

    @GetMapping
    public R<Page<ReportChart>> page(@RequestParam int page, @RequestParam int size) {
        return R.ok(svc.pageCharts(page, size));
    }

    @PostMapping
    public R<Void> create(@RequestBody ReportChart chart) {
        svc.createChart(chart);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody ReportChart chart) {
        svc.updateChart(id, chart);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deleteChart(id);
        return R.ok();
    }
}