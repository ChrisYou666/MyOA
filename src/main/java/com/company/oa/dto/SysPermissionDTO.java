// SysPermissionDTO.java
package com.company.oa.dto;
import lombok.Data;
import javax.validation.constraints.*;

@Data
public class SysPermissionDTO {
    @NotBlank private String code;
    @NotBlank private String name;
    @NotNull  private Long menuId;
    @NotBlank private String apiPath;
    @NotBlank private String method;
    private Integer status;
}