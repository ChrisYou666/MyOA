package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.SysMenuDTO;
import com.company.oa.vo.SysMenuVO;
import com.company.oa.service.SysMenuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/menus")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    @GetMapping
    public R<Page<SysMenuVO>> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(menuService.pageMenus(page, size));
    }

    @GetMapping("/{id}")
    public R<SysMenuVO> get(@PathVariable Long id) {
        return R.ok(menuService.getMenu(id));
    }

    @PostMapping
    public R<Void> create(@RequestBody @Valid SysMenuDTO dto) {
        menuService.createMenu(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid SysMenuDTO dto) {
        menuService.updateMenu(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return R.ok();
    }
}