package com.company.oa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.R;
import com.company.oa.entity.*;
import com.company.oa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/meeting-rooms")
public class MeetingRoomController {
    @Autowired private MeetingRoomService svc;

    @GetMapping
    public R<Page<MeetingRoom>> page(@RequestParam int page, @RequestParam int size) {
        return R.ok(svc.pageRooms(page, size));
    }

    @PostMapping
    public R<Void> create(@RequestBody @Valid MeetingRoom room) {
        svc.createRoom(room);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid MeetingRoom room) {
        svc.updateRoom(id, room);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        svc.deleteRoom(id);
        return R.ok();
    }
}