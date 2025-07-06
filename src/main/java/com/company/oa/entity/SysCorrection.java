package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

// SysCorrection.java
@Data
@TableName("sys_correction")
public class SysCorrection {
    @TableId(type = IdType.AUTO) private Long id;
    private Long userId;
    private LocalDate applyDate;
    private Integer type;
    private String reason;
    private Integer status;
    private Long approverId;
    private LocalDateTime approveTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}