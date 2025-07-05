package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.dto.SysPermissionDTO;
import com.company.oa.vo.SysPermissionVO;
import java.util.List;

public interface SysPermissionService {
    // 粗粒度：用户-角色、角色-菜单
    List<Long> getUserRoleIds(Long userId);
    void assignRolesToUser(Long userId, List<Long> roleIds);
    List<Long> getRoleMenuIds(Long roleId);
    void assignMenusToRole(Long roleId, List<Long> menuIds);

    // 细粒度：权限 CRUD
    Page<SysPermissionVO> pagePermissions(int page, int size);
    SysPermissionVO getPermission(Long id);
    void createPermission(SysPermissionDTO dto);
    void updatePermission(Long id, SysPermissionDTO dto);
    void deletePermission(Long id);

    // 细粒度：角色-权限
    List<Long> getRolePermissionIds(Long roleId);
    void assignPermissionsToRole(Long roleId, List<Long> permissionIds);
    List<String> getPermissionCodesByUser(Long userId);
}