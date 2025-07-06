package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class MeetingScheduleDTO {
    @NotNull
    private Long userId;
    @NotBlank
    private String title;
    @NotNull private LocalDateTime startTime;
    @NotNull private LocalDateTime endTime;
    private String description;
}