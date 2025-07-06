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
@RequestMapping("/api/metrics")
public class ApiMetricsController {
    @Autowired private ApiMetricsService svc;

    @GetMapping("/meters")
    public R<List<Meter>> listMeters() {
        return R.ok(svc.listAllMeters());
    }

    @GetMapping("/gauges")
    public R<Map<String, Double>> gauges() {
        return R.ok(svc.getGaugeMetrics());
    }
}