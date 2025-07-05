package com.company.oa.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.SysDeptDTO;
import com.company.oa.entity.SysDept;
import com.company.oa.mapper.SysDeptMapper;
import com.company.oa.vo.SysDeptVO;

public interface SysDeptService extends IService<SysDept> {
    Page pageDepts(int page, int size);

    SysDeptVO getDept(Long id);

    void createDept(SysDeptDTO dto);

    void updateDept(Long id,SysDeptDTO dto);

    void deleteDept(Long id);
}
