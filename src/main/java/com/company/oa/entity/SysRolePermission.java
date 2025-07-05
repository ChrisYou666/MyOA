package com.company.oa.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("sys_role_permission")
public class SysRolePermission {
    @TableId(type = IdType.AUTO) private Long id;
    @TableField("role_id") private Long roleId;
    @TableField("permission_id") private Long permissionId;
    @TableField(fill = FieldFill.INSERT) private LocalDateTime createTime;
}