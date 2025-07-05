package com.company.oa.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysPostVO {
    private Long id;
    private String name;
    private String code;
    private String description;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}