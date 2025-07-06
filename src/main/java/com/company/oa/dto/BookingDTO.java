package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class BookingDTO {
    @NotNull
    private Long roomId;
    @NotNull private Long userId;
    @NotNull private LocalDateTime startTime;
    @NotNull private LocalDateTime endTime;
    private String purpose;
}