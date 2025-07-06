package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.CustomReport;
import com.company.oa.entity.ReportChart;

import java.util.List;
import java.util.Map;

public interface CustomReportService {
    Page<CustomReport> pageReports(int page, int size);
    void createReport(CustomReport rpt);
    void updateReport(Long id, CustomReport rpt);
    void deleteReport(Long id);
    List<Map<String, Object>> runReport(Long id);
}