package com.company.oa.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeetingScheduleVO {
    private Long id;
    private Long userId;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
}