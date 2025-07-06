package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.entity.Asset;
import com.company.oa.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    @Autowired private AssetService svc;

    @PostMapping
    public R<Void> create(@RequestBody @Valid Asset asset) {
        svc.create(asset);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid Asset asset) {
        svc.update(id, asset);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return R.ok();
    }

    @GetMapping("/{id}")
    public R<Asset> get(@PathVariable Long id) {
        return R.ok(svc.getById(id));
    }

    @GetMapping
    public R<Page<Asset>> page(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(svc.page(page, size));
    }
}
