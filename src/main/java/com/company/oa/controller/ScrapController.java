package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.entity.Scrap;
import com.company.oa.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/scraps")
public class ScrapController {
    @Autowired private ScrapService svc;

    @PostMapping
    public R<Void> create(@RequestBody @Valid Scrap scrap) {
        svc.create(scrap);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid Scrap scrap) {
        svc.update(id, scrap);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return R.ok();
    }

    @GetMapping("/{id}")
    public R<Scrap> get(@PathVariable Long id) {
        return R.ok(svc.getById(id));
    }

    @GetMapping
    public R<Page<Scrap>> page(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(svc.page(page, size));
    }
}