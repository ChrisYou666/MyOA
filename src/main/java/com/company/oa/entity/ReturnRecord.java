package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@TableName("sys_return")
public class ReturnRecord {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long allocationId;
    private LocalDateTime returnedTime;
    private String condition;
    private Long createdBy;
    private LocalDateTime createdTime;
}