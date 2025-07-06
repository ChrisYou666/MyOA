package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.CustomReport;
import com.company.oa.entity.ReportChart;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Meter;

import java.util.List;
import java.util.Map;

public interface ApiMetricsService {
    List<Meter> listAllMeters();
    Map<String, Double> getGaugeMetrics();
}
