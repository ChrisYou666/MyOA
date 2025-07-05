package com.company.oa.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SysPostDTO {

    @NotBlank(message = "岗位名称不能为空")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "岗位编码不能为空")
    @Size(max = 50)
    private String code;

    private String description;

    private Integer status;
}