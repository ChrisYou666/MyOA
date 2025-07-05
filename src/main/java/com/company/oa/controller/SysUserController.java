package com.company.oa.controller;

import com.company.oa.service.SysUserService;
import com.company.oa.dto.SysUserDTO;
import com.company.oa.vo.SysUserVO;
import com.company.oa.common.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @GetMapping
    public R<Page<SysUserVO>> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<SysUserVO> result = userService.pageUsers(page, size);
        return R.ok(result);
    }

    @GetMapping("/{id}")
    public R<SysUserVO> get(@PathVariable Long id) {
        return R.ok(userService.getUser(id));
    }

    @PostMapping
    public R<Void> create(@RequestBody SysUserDTO dto) {
        userService.createUser(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody SysUserDTO dto) {
        userService.updateUser(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return R.ok();
    }
}