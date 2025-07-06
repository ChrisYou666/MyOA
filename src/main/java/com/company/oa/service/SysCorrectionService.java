package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.CorrectionDTO;
import com.company.oa.entity.SysCorrection;

public interface SysCorrectionService extends IService<SysCorrection> {
    Page<SysCorrection> pageCorrections(int page, int size, Long userId);
    void applyCorrection(CorrectionDTO dto);
    void approveCorrection(Long id, Long approverId, boolean pass);
}