package com.company.oa.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SysMenuDTO {

    @NotBlank(message = "菜单名称不能为空")
    private String name;

    @NotBlank(message = "路径不能为空")
    private String path;

    private String component;

    @NotNull(message = "父菜单ID不能为空")
    private Long parentId;

    private Integer orderNum;
    private Integer status;
}