package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@TableName("sys_allocation")
public class Allocation {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long assetId;
    private Long userId;
    private LocalDateTime allocatedTime;
    private Long createdBy;
    private LocalDateTime createdTime;
}