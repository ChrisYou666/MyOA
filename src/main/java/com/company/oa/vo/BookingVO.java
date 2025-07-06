package com.company.oa.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingVO {
    private Long id;
    private Long roomId;
    private Long userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
}