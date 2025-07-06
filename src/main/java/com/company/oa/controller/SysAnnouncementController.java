// src/main/java/com/company/oa/controller/SysAnnouncementController.java
package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.SysAnnouncementDTO;
import com.company.oa.vo.SysAnnouncementVO;
import com.company.oa.service.SysAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class SysAnnouncementController {

    @Autowired private SysAnnouncementService svc;

    @GetMapping
    public R<Page<SysAnnouncementVO>> page(
            @RequestParam(defaultValue="1") int page,
            @RequestParam(defaultValue="10") int size) {
        return R.ok(svc.pageAnnouncements(page, size));
    }

    @GetMapping("/{id}")
    public R<SysAnnouncementVO> get(@PathVariable Long id) {
        return R.ok(svc.getAnnouncement(id));
    }

    @PostMapping
    public R<Void> create(@RequestBody @Valid SysAnnouncementDTO dto) {
        svc.createAnnouncement(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(
            @PathVariable Long id,
            @RequestBody @Valid SysAnnouncementDTO dto) {
        svc.updateAnnouncement(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deleteAnnouncement(id);
        return R.ok();
    }

    // 发送通知
    @PostMapping("/{id}/notify")
    public R<Void> notify(
            @PathVariable("id") Long announcementId,
            @RequestBody List<Long> userIds) {
        svc.sendNotification(announcementId, userIds);
        return R.ok();
    }
}