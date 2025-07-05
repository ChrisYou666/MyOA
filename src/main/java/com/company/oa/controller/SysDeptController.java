package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.SysDeptDTO;
import com.company.oa.vo.SysDeptVO;
import com.company.oa.service.SysDeptService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/depts")
public class SysDeptController {
    @Autowired
    private SysDeptService service;

    @GetMapping
    public R<Page<SysDeptVO>> list(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="10") int size) {
        return R.ok(service.pageDepts(page, size));
    }

    @GetMapping("/{id}")
    public R<SysDeptVO> get(@PathVariable Long id) {
        return R.ok(service.getDept(id));
    }

    @PostMapping
    public R<Void> create(@RequestBody SysDeptDTO dto) {
        service.createDept(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id,@RequestBody SysDeptDTO dto) {
        service.updateDept(id,dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        service.deleteDept(id);
        return R.ok();
    }
}