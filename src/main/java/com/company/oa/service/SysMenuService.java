package com.company.oa.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.SysMenuDTO;
import com.company.oa.entity.SysMenu;
import com.company.oa.vo.SysMenuVO;

public interface SysMenuService extends IService<SysMenu> {
    Page<SysMenuVO> pageMenus(int page, int size);
    SysMenuVO getMenu(Long id);
    void createMenu(SysMenuDTO dto);
    void updateMenu(Long id, SysMenuDTO dto);
    void deleteMenu(Long id);
}
