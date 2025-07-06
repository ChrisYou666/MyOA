package com.company.oa.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysDocumentVO {
    private Long id;
    private String title;
    private String description;
    private Long createdBy;
    private LocalDateTime createdTime;
}