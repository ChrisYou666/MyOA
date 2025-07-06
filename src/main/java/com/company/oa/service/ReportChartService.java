package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.CustomReport;
import com.company.oa.entity.ReportChart;

import java.util.List;
import java.util.Map;

public interface ReportChartService {
    Page<ReportChart> pageCharts(int page, int size);
    void createChart(ReportChart chart);
    void updateChart(Long id, ReportChart chart);
    void deleteChart(Long id);
}