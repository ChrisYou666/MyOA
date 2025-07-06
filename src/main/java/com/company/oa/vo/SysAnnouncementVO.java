package com.company.oa.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysAnnouncementVO {
    private Long id;
    private String title;
    private String content;
    private Long createdBy;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}