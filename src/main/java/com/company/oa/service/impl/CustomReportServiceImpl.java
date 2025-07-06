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
public class CustomReportServiceImpl implements CustomReportService {
    @Autowired private CustomReportMapper mapper;
    @Autowired private JdbcTemplate jdbc;

    @Override
    public Page<CustomReport> pageReports(int page, int size) {
        return mapper.selectPage(new Page<>(page, size), null);
    }

    @Override public void createReport(CustomReport rpt) { mapper.insert(rpt); }
    @Override public void updateReport(Long id, CustomReport rpt) {
        rpt.setId(id);
        mapper.updateById(rpt);
    }
    @Override public void deleteReport(Long id) { mapper.deleteById(id); }

    @Override
    public List<Map<String, Object>> runReport(Long id) {
        CustomReport rpt = mapper.selectById(id);
        return jdbc.queryForList(rpt.getSqlQuery());
    }
}