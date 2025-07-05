package com.company.oa.dto;

import lombok.Data;

@Data
public class SysUserDTO {
    private String username;
    private String password;   // 创建或重置密码时使用
    private String realName;
    private String email;
    private String mobile;
    private Integer status;
    private Long deptId;
}