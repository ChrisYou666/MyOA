package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_custom_report")
public class CustomReport {
    @TableId(type = IdType.AUTO) private Long id;
    private String name;
    @TableField("sql_query") private String sqlQuery;
    @TableField("created_by") private Long createdBy;
    @TableField("created_time") private LocalDateTime createdTime;
    @TableField("updated_time") private LocalDateTime updatedTime;
}