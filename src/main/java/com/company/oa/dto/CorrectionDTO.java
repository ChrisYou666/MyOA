package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CorrectionDTO {
    @NotNull private Long userId;
    @NotNull private LocalDate applyDate;
    @NotNull
    private Integer type;      // 1 上班补卡；2 下班补卡
    @NotBlank
    private String reason;
}