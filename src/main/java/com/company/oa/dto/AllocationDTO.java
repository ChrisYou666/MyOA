package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class AllocationDTO {
    @NotNull
    private Long assetId;
    @NotNull
    private Long userId;
    @NotNull
    private LocalDateTime allocatedTime;
    @NotNull
    private Long createdBy;
}