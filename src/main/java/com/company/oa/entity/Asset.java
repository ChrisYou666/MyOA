package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@TableName("sys_asset")
public class Asset {
    @TableId(type = IdType.AUTO)
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