package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.SysRoleDTO;
import com.company.oa.vo.SysRoleVO;
import com.company.oa.service.SysRoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    @GetMapping
    public R<Page<SysRoleVO>> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(roleService.pageRoles(page, size));
    }

    @GetMapping("/{id}")
    public R<SysRoleVO> get(@PathVariable Long id) {
        return R.ok(roleService.getRole(id));
    }

    @PostMapping
    public R<Void> create(@RequestBody @Valid SysRoleDTO dto) {
        roleService.createRole(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid SysRoleDTO dto) {
        roleService.updateRole(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        roleService.deleteRole(id);
        return R.ok();
    }
}