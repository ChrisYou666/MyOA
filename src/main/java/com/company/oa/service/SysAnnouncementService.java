package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.SysAnnouncementDTO;
import com.company.oa.entity.SysAnnouncement;
import com.company.oa.entity.SysNotification;
import com.company.oa.vo.SysAnnouncementVO;

import java.util.List;

public interface SysAnnouncementService extends IService<SysAnnouncement> {
    Page<SysAnnouncementVO> pageAnnouncements(int page, int size);
    SysAnnouncementVO getAnnouncement(Long id);
    void createAnnouncement(SysAnnouncementDTO dto);
    void updateAnnouncement(Long id, SysAnnouncementDTO dto);
    void deleteAnnouncement(Long id);

    List<SysNotification> sendNotification(Long announcementId, List<Long> userIds);
}
