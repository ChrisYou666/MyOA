package com.company.oa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.entity.Allocation;
import com.company.oa.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/allocations")
public class AllocationController {
    @Autowired private AllocationService svc;

    @PostMapping
    public R<Void> create(@RequestBody @Valid Allocation allocation) {
        svc.create(allocation);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid Allocation allocation) {
        svc.update(id, allocation);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return R.ok();
    }

    @GetMapping("/{id}")
    public R<Allocation> get(@PathVariable Long id) {
        return R.ok(svc.getById(id));
    }

    @GetMapping
    public R<Page<Allocation>> page(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(svc.page(page, size));
    }
}