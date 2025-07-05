package com.company.oa.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysUserVO {
    private Long id;
    private String username;
    private String realName;
    private String email;
    private String mobile;
    private Integer status;
    private String deptName;        // 关联 Dept 表的名称
    private LocalDateTime createTime;
}