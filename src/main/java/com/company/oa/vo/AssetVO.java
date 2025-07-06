package com.company.oa.vo;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AssetVO {
    private Long id;
    private String assetName;
    private String assetCode;
    private String category;
    private LocalDate purchaseDate;
    private String status;
    private Long createdBy;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}