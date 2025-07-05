package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.SysRoleDTO;
import com.company.oa.vo.SysRoleVO;
import com.company.oa.service.SysRoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    @GetMapping
    @PreAuthorize("hasAuthority('MENU_ROLE_VIEW')")
    public R<Page<SysRoleVO>> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(roleService.pageRoles(page, size));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('MENU_ROLE_VIEW')")
    public R<SysRoleVO> get(@PathVariable Long id) {
        return R.ok(roleService.getRole(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('MENU_ROLE_ADD')")
    public R<Void> create(@RequestBody @Valid SysRoleDTO dto) {
        roleService.createRole(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('MENU_ROLE_EDIT')")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid SysRoleDTO dto) {
        roleService.updateRole(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('MENU_ROLE_DELETE')")
    public R<Void> delete(@PathVariable Long id) {
        roleService.deleteRole(id);
        return R.ok();
    }
}