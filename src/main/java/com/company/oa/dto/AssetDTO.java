package com.company.oa.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class AssetDTO {
    @NotBlank
    private String assetName;
    @NotBlank
    private String assetCode;
    @NotBlank
    private String category;
    @NotNull
    private LocalDate purchaseDate;
    @NotBlank
    private String status;
    @NotNull
    private Long createdBy;
}