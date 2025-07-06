package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@TableName("sys_scrap")
public class Scrap {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long assetId;
    private String scrapReason;
    private LocalDateTime scrapTime;
    private Long createdBy;
    private LocalDateTime createdTime;
}