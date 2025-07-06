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
@TableName("sys_booking")
public class Booking {
    @TableId(type = IdType.AUTO) private Long id;
    @TableField("room_id") private Long roomId;
    @TableField("user_id") private Long userId;
    @TableField("start_time") private LocalDateTime startTime;
    @TableField("end_time") private LocalDateTime endTime;
    private String purpose;
    private String status;
    @TableField("created_time") private LocalDateTime createdTime;
}