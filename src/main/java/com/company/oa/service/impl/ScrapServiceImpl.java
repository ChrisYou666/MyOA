package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.Scrap;
import com.company.oa.mapper.ScrapMapper;
import com.company.oa.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrapServiceImpl implements ScrapService {
    @Autowired private ScrapMapper mapper;

    @Override
    public void create(Scrap scrap) {
        mapper.insert(scrap);
    }

    @Override
    public void update(Long id, Scrap scrap) {
        scrap.setId(id);
        mapper.updateById(scrap);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public Scrap getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<Scrap> page(int page, int size) {
        return mapper.selectPage(new Page<>(page, size), null);
    }
}