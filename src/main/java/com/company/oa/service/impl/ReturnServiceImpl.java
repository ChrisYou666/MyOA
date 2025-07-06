package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.ReturnRecord;
import com.company.oa.mapper.ReturnRecordMapper;
import com.company.oa.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired private ReturnRecordMapper mapper;

    @Override
    public void create(ReturnRecord record) {
        mapper.insert(record);
    }

    @Override
    public void update(Long id, ReturnRecord record) {
        record.setId(id);
        mapper.updateById(record);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public ReturnRecord getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<ReturnRecord> page(int page, int size) {
        return mapper.selectPage(new Page<>(page, size), null);
    }
}