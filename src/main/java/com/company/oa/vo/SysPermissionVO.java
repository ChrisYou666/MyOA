
// SysPermissionVO.java
package com.company.oa.vo;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SysPermissionVO {
    private Long id;
    private String code;
    private String name;
    private Long menuId;
    private String apiPath;
    private String method;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
