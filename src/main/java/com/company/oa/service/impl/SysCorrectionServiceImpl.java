package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.dto.CorrectionDTO;
import com.company.oa.entity.SysCorrection;
import com.company.oa.mapper.SysCorrectionMapper;
import com.company.oa.service.SysCorrectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SysCorrectionServiceImpl extends ServiceImpl<SysCorrectionMapper, SysCorrection>implements SysCorrectionService {
    @Autowired
    private SysCorrectionMapper corrMapper;

    @Override
    public Page<SysCorrection> pageCorrections(int page, int size, Long userId) {
        return corrMapper.selectPage(new Page<>(page,size),
                Wrappers.<SysCorrection>lambdaQuery()
                        .eq(userId!=null, SysCorrection::getUserId, userId)
                        .orderByDesc(SysCorrection::getApplyDate));
    }

    @Override
    public void applyCorrection(CorrectionDTO dto) {
        SysCorrection c = new SysCorrection();
        BeanUtils.copyProperties(dto, c);
        c.setStatus(0);
        c.setCreatedTime(LocalDateTime.now());
        corrMapper.insert(c);
    }

    @Override
    public void approveCorrection(Long id, Long approverId, boolean pass) {
        SysCorrection c = new SysCorrection();
        c.setId(id);
        c.setApproverId(approverId);
        c.setApproveTime(LocalDateTime.now());
        c.setStatus(pass ? 1 : 2);
        corrMapper.updateById(c);
    }
}