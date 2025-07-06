package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.ReturnRecord;

public interface ReturnService {
    void create(ReturnRecord record);
    void update(Long id, ReturnRecord record);
    void delete(Long id);
    ReturnRecord getById(Long id);
    Page<ReturnRecord> page(int page, int size);
}