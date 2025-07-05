package com.company.oa.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("sys_role_menu")
public class SysRoleMenu {
    @TableId(type = IdType.AUTO) private Long id;
    @TableField("role_id") private Long roleId;
    @TableField("menu_id") private Long menuId;
    @TableField(fill = FieldFill.INSERT) private LocalDateTime createTime;
}