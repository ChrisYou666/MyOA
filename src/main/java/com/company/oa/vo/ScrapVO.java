package com.company.oa.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScrapVO {
    private Long id;
    private Long assetId;
    private String scrapReason;
    private LocalDateTime scrapTime;
    private Long createdBy;
    private LocalDateTime createdTime;
}