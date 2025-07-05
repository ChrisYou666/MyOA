package com.company.oa.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class SysDeptDTO {
    @NotBlank
    private String name;
    private Long parentId;
    private Integer orderNum;
    private Integer status;
}