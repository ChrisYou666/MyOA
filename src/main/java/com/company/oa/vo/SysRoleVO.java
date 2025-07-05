package com.company.oa.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysRoleVO {
    private Long id;
    private String name;
    private String code;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}