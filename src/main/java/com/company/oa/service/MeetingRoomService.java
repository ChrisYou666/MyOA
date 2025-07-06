package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.entity.MeetingRoom;

public interface MeetingRoomService extends IService<MeetingRoom> {
    Page<MeetingRoom> pageRooms(int page, int size);
    void createRoom(MeetingRoom room);
    void updateRoom(Long id, MeetingRoom room);
    void deleteRoom(Long id);
}