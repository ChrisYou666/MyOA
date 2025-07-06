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
public class MeetingRoomServiceImpl extends ServiceImpl<MeetingRoomMapper,MeetingRoom> implements MeetingRoomService {
    @Autowired private MeetingRoomMapper mapper;

    @Override
    public Page<MeetingRoom> pageRooms(int page, int size) {
        return mapper.selectPage(new Page<>(page, size), null);
    }

    @Override public void createRoom(MeetingRoom room) { mapper.insert(room); }
    @Override public void updateRoom(Long id, MeetingRoom room) {
        room.setId(id);
        mapper.updateById(room);
    }
    @Override public void deleteRoom(Long id) { mapper.deleteById(id); }
}