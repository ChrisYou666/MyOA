package com.company.oa.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReturnRecordVO {
    private Long id;
    private Long allocationId;
    private LocalDateTime returnedTime;
    private String condition;
    private Long createdBy;
    private LocalDateTime createdTime;
}