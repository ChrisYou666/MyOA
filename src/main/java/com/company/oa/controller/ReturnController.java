package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.entity.ReturnRecord;
import com.company.oa.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/returns")
public class ReturnController {
    @Autowired private ReturnService svc;

    @PostMapping
    public R<Void> create(@RequestBody @Valid ReturnRecord record) {
        svc.create(record);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid ReturnRecord record) {
        svc.update(id, record);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return R.ok();
    }

    @GetMapping("/{id}")
    public R<ReturnRecord> get(@PathVariable Long id) {
        return R.ok(svc.getById(id));
    }

    @GetMapping
    public R<Page<ReturnRecord>> page(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(svc.page(page, size));
    }
}
