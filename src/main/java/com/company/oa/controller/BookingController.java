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
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired private BookingService svc;

    @GetMapping("/room/{roomId}")
    public R<List<Booking>> listByRoom(@PathVariable Long roomId) {
        return R.ok(svc.listByRoom(roomId));
    }

    @PostMapping
    public R<Void> create(@RequestBody @Valid Booking booking) {
        svc.createBooking(booking);
        return R.ok();
    }

    @PutMapping("/{id}/cancel")
    public R<Void> cancel(@PathVariable Long id) {
        svc.cancelBooking(id);
        return R.ok();
    }
}