package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.Allocation;

public interface AllocationService {
    void create(Allocation allocation);
    void update(Long id, Allocation allocation);
    void delete(Long id);
    Allocation getById(Long id);
    Page<Allocation> page(int page, int size);
}