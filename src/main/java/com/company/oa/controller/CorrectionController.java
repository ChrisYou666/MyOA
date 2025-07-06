package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.dto.CorrectionDTO;
import com.company.oa.entity.SysCorrection;
import com.company.oa.service.SysCorrectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/correction")
public class CorrectionController {
    @Autowired
    private SysCorrectionService svc;

    @GetMapping
    public R<Page<SysCorrection>> page(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required=false) Long userId
    ) {
        return R.ok(svc.pageCorrections(page,size,userId));
    }

    @PostMapping
    public R<Void> apply(@RequestBody @Valid CorrectionDTO dto) {
        svc.applyCorrection(dto);
        return R.ok();
    }

    @PostMapping("/{id}/approve")
    public R<Void> approve(
            @PathVariable Long id,
            @RequestParam Long approverId,
            @RequestParam boolean pass
    ) {
        svc.approveCorrection(id, approverId, pass);
        return R.ok();
    }
}