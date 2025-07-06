package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sys_document")
public class SysDocument {
    private Long id;
    private String title;
    private String description;
    private Long createdBy;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}