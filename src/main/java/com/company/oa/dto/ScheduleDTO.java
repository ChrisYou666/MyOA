package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ScheduleDTO {
    private Long userId;
    private LocalDate workDate;
    private String shiftCode;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
}