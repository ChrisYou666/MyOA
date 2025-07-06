package com.company.oa.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AllocationVO {
    private Long id;
    private Long assetId;
    private Long userId;
    private LocalDateTime allocatedTime;
    private Long createdBy;
    private LocalDateTime createdTime;
}