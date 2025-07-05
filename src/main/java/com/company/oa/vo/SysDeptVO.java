package com.company.oa.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysDeptVO {
    private Long id;
    private String name;
    private Long parentId;
    private Integer orderNum;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}