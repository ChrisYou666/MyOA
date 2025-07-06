package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.dto.SysDocumentDTO;
import com.company.oa.dto.SysDocumentVersionDTO;
import com.company.oa.service.SysDocumentService;
import com.company.oa.vo.SysDocumentVO;
import com.company.oa.vo.SysDocumentVersionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class SysDocumentController {
    @Autowired
    private SysDocumentService svc;

    @PostMapping
    public R<Long> create(@Valid @RequestBody SysDocumentDTO dto) {
        return R.ok(svc.createDocument(dto));
    }

    @GetMapping
    public R<Page<SysDocumentVO>> page(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="10") int size) {
        return R.ok(svc.pageDocuments(page, size));
    }

    @PutMapping("/{id}")
    public R<Void> update(
            @PathVariable Long id,
            @Valid @RequestBody SysDocumentDTO dto) {
        svc.updateDocument(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deleteDocument(id);
        return R.ok();
    }

    @PostMapping("/{id}/versions")
    public R<Long> addVersion(
            @PathVariable Long id,
            @Valid @RequestBody SysDocumentVersionDTO dto) {
        return R.ok(svc.addVersion(id, dto));
    }

    @GetMapping("/{id}/versions")
    public R<List<SysDocumentVersionVO>> listVersions(@PathVariable Long id) {
        return R.ok(svc.listVersions(id));
    }
}