package com.company.oa.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("sys_permission")
public class SysPermission {
    @TableId(type = IdType.AUTO) private Long id;
    private String code;
    private String name;
    @TableField("menu_id") private Long menuId;
    @TableField("api_path") private String apiPath;
    private String method;
    private Integer status;
    @TableField(fill = FieldFill.INSERT)      private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE) private LocalDateTime updateTime;
}