// src/main/java/com/company/oa/controller/SysNotificationController.java
package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.SysNotificationDTO;
import com.company.oa.vo.SysNotificationVO;
import com.company.oa.service.SysNotificationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class SysNotificationController {

    @Autowired private SysNotificationService svc;

    @GetMapping("/page")
    public R<Page<SysNotificationVO>> page(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam Long receiverId) {
        return R.ok(svc.pageNotifications(page, size, receiverId));
    }

    @GetMapping("/{id}")
    public R<SysNotificationVO> get(@PathVariable Long id) {
        return R.ok(svc.getNotification(id));
    }

    @PostMapping
    public R<Void> create(@RequestBody @Valid SysNotificationDTO dto) {
        svc.createNotification(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(
            @PathVariable Long id,
            @RequestBody @Valid SysNotificationDTO dto) {
        svc.updateNotification(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deleteNotification(id);
        return R.ok();
    }

    /** 标记为已读 */
    @PostMapping("/{id}/read")
    public R<Void> markRead(@PathVariable Long id) {
        svc.markAsRead(id);
        return R.ok();
    }

    /** 获取某用户全部通知 */
    @GetMapping("/user/{receiverId}")
    public R<List<SysNotificationVO>> listByUser(@PathVariable Long receiverId) {
        return R.ok(svc.listByReceiver(receiverId));
    }
}