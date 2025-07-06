package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.Asset;
import com.company.oa.mapper.AssetMapper;
import com.company.oa.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {
    @Autowired private AssetMapper mapper;

    @Override
    public void create(Asset asset) {
        mapper.insert(asset);
    }

    @Override
    public void update(Long id, Asset asset) {
        asset.setId(id);
        mapper.updateById(asset);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public Asset getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<Asset> page(int page, int size) {
        return mapper.selectPage(new Page<>(page, size), null);
    }
}