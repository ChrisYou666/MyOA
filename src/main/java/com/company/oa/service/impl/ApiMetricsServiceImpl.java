package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.*;
import com.company.oa.mapper.*;
import com.company.oa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Meter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ApiMetricsServiceImpl implements ApiMetricsService {
    @Autowired private MeterRegistry registry;

    @Override
    public List<Meter> listAllMeters() {
        return registry.getMeters();
    }

    @Override
    public Map<String, Double> getGaugeMetrics() {
        return registry.getMeters().stream()
                .filter(m -> "gauge".equalsIgnoreCase(m.getId().getType().name()))
                .collect(Collectors.toMap(m -> m.getId().getName(),
                        m -> registry.get(m.getId().getName()).gauge().value()));
    }
}