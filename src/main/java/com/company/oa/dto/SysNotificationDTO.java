// src/main/java/com/company/oa/dto/SysNotificationDTO.java
package com.company.oa.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class SysNotificationDTO {
    @NotNull
    private Long announcementId;
    @NotNull
    private Long receiverId;
    /** 0=未读,1=已读 */
    private Integer status = 0;
    private LocalDateTime sentTime;
}