package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.SysPermissionDTO;
import com.company.oa.vo.SysPermissionVO;
import com.company.oa.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class SysPermissionController {

    @Autowired private SysPermissionService svc;

    // —— 粗粒度：用户–角色 —— //

    /** 查看用户角色 */
    @PreAuthorize("hasAuthority('PERMISSION_USER_ROLE_VIEW')")
    @GetMapping("/user/{userId}/roles")
    public R<List<Long>> getUserRoles(@PathVariable Long userId) {
        return R.ok(svc.getUserRoleIds(userId));
    }

    /** 编辑（设置）用户角色 */
    @PreAuthorize("hasAuthority('PERMISSION_USER_ROLE_EDIT')")
    @PostMapping("/user/{userId}/roles")
    public R<Void> setUserRoles(
            @PathVariable Long userId,
            @RequestBody List<Long> roleIds) {
        svc.assignRolesToUser(userId, roleIds);
        return R.ok();
    }

    // —— 粗粒度：角色–菜单 —— //

    /** 查看角色菜单 */
    @PreAuthorize("hasAuthority('PERMISSION_ROLE_MENU_VIEW')")
    @GetMapping("/role/{roleId}/menus")
    public R<List<Long>> getRoleMenus(@PathVariable Long roleId) {
        return R.ok(svc.getRoleMenuIds(roleId));
    }

    /** 编辑（设置）角色菜单 */
    @PreAuthorize("hasAuthority('PERMISSION_ROLE_MENU_EDIT')")
    @PostMapping("/role/{roleId}/menus")
    public R<Void> setRoleMenus(
            @PathVariable Long roleId,
            @RequestBody List<Long> menuIds) {
        svc.assignMenusToRole(roleId, menuIds);
        return R.ok();
    }

    // —— 细粒度：权限 CRUD —— //

    /** 分页查看所有权限 */
    @PreAuthorize("hasAuthority('MENU_PERMISSION_VIEW')")
    @GetMapping
    public R<Page<SysPermissionVO>> page(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="10") int size) {
        return R.ok(svc.pagePermissions(page,size));
    }

    /** 查看单个权限 */
    @PreAuthorize("hasAuthority('MENU_PERMISSION_VIEW')")
    @GetMapping("/{id}")
    public R<SysPermissionVO> get(@PathVariable Long id) {
        return R.ok(svc.getPermission(id));
    }

    /** 新增权限 */
    @PreAuthorize("hasAuthority('MENU_PERMISSION_ADD')")
    @PostMapping
    public R<Void> create(@RequestBody @Valid SysPermissionDTO dto) {
        svc.createPermission(dto);
        return R.ok();
    }

    /** 修改权限 */
    @PreAuthorize("hasAuthority('MENU_PERMISSION_EDIT')")
    @PutMapping("/{id}")
    public R<Void> update(
            @PathVariable Long id,
            @RequestBody @Valid SysPermissionDTO dto) {
        svc.updatePermission(id,dto);
        return R.ok();
    }

    /** 删除权限 */
    @PreAuthorize("hasAuthority('MENU_PERMISSION_DELETE')")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deletePermission(id);
        return R.ok();
    }

    // —— 细粒度：角色–权限 —— //

    /** 查看角色对应的权限 */
    @PreAuthorize("hasAuthority('PERMISSION_ROLE_PERMISSION_VIEW')")
    @GetMapping("/role/{roleId}")
    public R<List<Long>> getRolePerms(@PathVariable Long roleId) {
        return R.ok(svc.getRolePermissionIds(roleId));
    }

    /** 编辑（设置）角色权限 */
    @PreAuthorize("hasAuthority('PERMISSION_ROLE_PERMISSION_EDIT')")
    @PostMapping("/role/{roleId}")
    public R<Void> setRolePerms(
            @PathVariable Long roleId,
            @RequestBody List<Long> permIds) {
        svc.assignPermissionsToRole(roleId, permIds);
        return R.ok();
    }
}