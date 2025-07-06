package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.entity.*;
import com.company.oa.mapper.*;
import com.company.oa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl extends ServiceImpl<BookingMapper,Booking> implements BookingService {
    @Autowired private BookingMapper mapper;

    @Override
    public List<Booking> listByRoom(Long roomId) {
        return mapper.selectList(new QueryWrapper<Booking>().eq("room_id", roomId));
    }

    @Override public void createBooking(Booking booking) { mapper.insert(booking); }

    @Override public void cancelBooking(Long id) {
        Booking b = new Booking();
        b.setId(id);
        b.setStatus("CANCELLED");
        mapper.updateById(b);
    }
}