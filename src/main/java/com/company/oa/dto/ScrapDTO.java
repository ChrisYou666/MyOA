package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ScrapDTO {
    @NotNull
    private Long assetId;
    @NotBlank
    private String scrapReason;
    @NotNull
    private LocalDateTime scrapTime;
    @NotNull
    private Long createdBy;
}