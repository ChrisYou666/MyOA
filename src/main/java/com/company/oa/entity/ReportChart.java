package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_report_chart")
public class ReportChart {
    @TableId(type = IdType.AUTO) private Long id;
    @TableField("report_id") private Long reportId;
    private String type;
    @TableField("config_json") private String configJson;
    @TableField("created_time") private LocalDateTime createdTime;
}