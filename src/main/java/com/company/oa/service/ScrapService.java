package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.entity.Scrap;

public interface ScrapService {
    void create(Scrap scrap);
    void update(Long id, Scrap scrap);
    void delete(Long id);
    Scrap getById(Long id);
    Page<Scrap> page(int page, int size);
}