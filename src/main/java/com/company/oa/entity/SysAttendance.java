package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

// SysAttendance.java
@Data
@TableName("sys_attendance")
public class SysAttendance {
    @TableId(type = IdType.AUTO) private Long id;
    private Long userId;
    private LocalDate clockDate;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private Integer status;
    private Long createdBy;
    private LocalDateTime createdTime;
    private Long updatedBy;
    private LocalDateTime updatedTime;
}