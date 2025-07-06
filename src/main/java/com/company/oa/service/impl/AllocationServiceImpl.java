package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.Allocation;
import com.company.oa.mapper.AllocationMapper;
import com.company.oa.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationServiceImpl implements AllocationService {
    @Autowired private AllocationMapper mapper;

    @Override
    public void create(Allocation allocation) {
        mapper.insert(allocation);
    }

    @Override
    public void update(Long id, Allocation allocation) {
        allocation.setId(id);
        mapper.updateById(allocation);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public Allocation getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<Allocation> page(int page, int size) {
        return mapper.selectPage(new Page<>(page, size), null);
    }
}