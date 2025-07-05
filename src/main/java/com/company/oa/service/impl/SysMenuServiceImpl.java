package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.dto.SysMenuDTO;
import com.company.oa.entity.SysMenu;
import com.company.oa.mapper.SysMenuMapper;
import com.company.oa.service.SysMenuService;
import com.company.oa.vo.SysMenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>implements SysMenuService {
    @Override
    public Page<SysMenuVO> pageMenus(int page, int size) {
        Page<SysMenu> pe = this.page(new Page<>(page, size));
        return (Page<SysMenuVO>) pe.convert(e -> {
            SysMenuVO vo = new SysMenuVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        });
    }

    @Override
    public SysMenuVO getMenu(Long id) {
        SysMenu e = this.getById(id);
        SysMenuVO vo = new SysMenuVO();
        BeanUtils.copyProperties(e, vo);
        return vo;
    }

    @Override
    public void createMenu(SysMenuDTO dto) {
        SysMenu e = new SysMenu();
        BeanUtils.copyProperties(dto, e);
        this.save(e);
    }

    @Override
    public void updateMenu(Long id, SysMenuDTO dto) {
        SysMenu e = new SysMenu();
        BeanUtils.copyProperties(dto, e);
        e.setId(id);
        this.updateById(e);
    }

    @Override
    public void deleteMenu(Long id) {
        this.removeById(id);
    }
}
