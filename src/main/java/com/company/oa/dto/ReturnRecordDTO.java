package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ReturnRecordDTO {
    @NotNull
    private Long allocationId;
    @NotNull
    private LocalDateTime returnedTime;
    @NotBlank
    private String condition;
    @NotNull
    private Long createdBy;
}
