package com.company.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.oa.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 查询指定用户可访问的所有菜单（平铺列表）
     */
    @Select({
            "SELECT m.*",
            "FROM sys_menu m",
            "JOIN sys_role_menu rm ON m.id = rm.menu_id",
            "JOIN sys_user_role ur ON rm.role_id = ur.role_id",
            "WHERE ur.user_id = #{userId}",
            "  AND m.status = 1",
            "ORDER BY m.parent_id, m.order_num"
    })
    List<SysMenu> selectMenuByUserId(@Param("userId") Long userId);
}
