package com.company.oa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.entity.Booking;

import java.util.List;

public interface BookingService extends IService<Booking> {
    List<Booking> listByRoom(Long roomId);
    void createBooking(Booking booking);
    void cancelBooking(Long id);
}