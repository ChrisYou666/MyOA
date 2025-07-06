package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("sys_notification")
public class SysNotification {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long announcementId;
    private Long receiverId;
    private Integer status;
    private LocalDateTime sentTime;
}