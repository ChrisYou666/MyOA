package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.Asset;

public interface AssetService {
    void create(Asset asset);
    void update(Long id, Asset asset);
    void delete(Long id);
    Asset getById(Long id);
    Page<Asset> page(int page, int size);
}