package com.company.oa.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AttendanceDTO {
    private Long userId;
    private LocalDate clockDate;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private Integer status;
}