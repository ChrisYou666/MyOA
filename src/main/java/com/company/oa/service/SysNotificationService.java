package com.company.oa.service;

import com.company.oa.dto.SysNotificationDTO;
import com.company.oa.vo.SysNotificationVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface SysNotificationService {
    Page<SysNotificationVO> pageNotifications(int page, int size, Long receiverId);
    SysNotificationVO getNotification(Long id);
    void createNotification(SysNotificationDTO dto);
    void updateNotification(Long id, SysNotificationDTO dto);
    void deleteNotification(Long id);
    void markAsRead(Long id);
    List<SysNotificationVO> listByReceiver(Long receiverId);
}