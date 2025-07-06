package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// SysSchedule.java
@Data
@TableName("sys_schedule")
public class SysSchedule {
    @TableId(type = IdType.AUTO) private Long id;
    private Long userId;
    private LocalDate workDate;
    private String shiftCode;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
    private Long createdBy;
    private LocalDateTime createdTime;
    private Long updatedBy;
    private LocalDateTime updatedTime;
}