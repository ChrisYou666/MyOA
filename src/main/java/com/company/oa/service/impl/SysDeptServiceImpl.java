package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.entity.SysDept;
import com.company.oa.mapper.SysDeptMapper;
import com.company.oa.dto.SysDeptDTO;
import com.company.oa.vo.SysDeptVO;
import com.company.oa.service.SysDeptService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Service
public class SysDeptServiceImpl
        extends ServiceImpl<SysDeptMapper, SysDept>
        implements SysDeptService {

    @Override
    public Page pageDepts(int page, int size) {
        // 1. 原始分页查询：得到 Page<SysDept>
        Page<SysDept>  pe      = this.page(new Page<>(page, size));
        // 5. 返回 VO 分页
        return pe;
    }

    @Override
    public SysDeptVO getDept(Long id) {
        SysDept e = this.getById(id);
        SysDeptVO vo = new SysDeptVO();
        BeanUtils.copyProperties(e, vo);
        return vo;
    }

    @Override
    public void createDept(SysDeptDTO dto) {
        SysDept e = new SysDept();
        BeanUtils.copyProperties(dto, e);
        this.save(e);
    }

    @Override
    public void updateDept(Long id,SysDeptDTO dto) {
        SysDept e = new SysDept();
        BeanUtils.copyProperties(dto, e);
        e.setId(id);
        this.updateById(e);
    }

    @Override
    public void deleteDept(Long id) {
        this.removeById(id);
    }
}