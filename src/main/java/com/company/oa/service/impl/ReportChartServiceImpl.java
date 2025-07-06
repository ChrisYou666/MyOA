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
public class ReportChartServiceImpl implements ReportChartService {
    @Autowired private ReportChartMapper mapper;

    @Override
    public Page<ReportChart> pageCharts(int page, int size) {
        return mapper.selectPage(new Page<>(page, size), null);
    }

    @Override public void createChart(ReportChart chart) { mapper.insert(chart); }
    @Override public void updateChart(Long id, ReportChart chart) {
        chart.setId(id);
        mapper.updateById(chart);
    }
    @Override public void deleteChart(Long id) { mapper.deleteById(id); }
}