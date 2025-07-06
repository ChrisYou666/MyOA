package com.company.oa.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_meeting_room")
public class MeetingRoom {
    @TableId(type = IdType.AUTO) private Long id;
    private String name;
    private String location;
    private Integer capacity;
    @TableField("created_by") private Long createdBy;
    @TableField("created_time") private LocalDateTime createdTime;
    @TableField("updated_time") private LocalDateTime updatedTime;
}