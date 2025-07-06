package com.company.oa.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysNotificationVO {
    private Long id;
    private Long announcementId;
    private Long receiverId;
    private Integer status;
    private LocalDateTime sentTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}