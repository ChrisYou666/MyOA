package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.dto.SysMenuDTO;
import com.company.oa.entity.SysMenu;
import com.company.oa.mapper.SysMenuMapper;
import com.company.oa.service.SysMenuService;
import com.company.oa.vo.MenuTreeVO;
import com.company.oa.vo.SysMenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu>implements SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;
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

    @Override
    public List<MenuTreeVO> getMenuTreeByUserId(Long userId) {
        // 1. 查询平铺列表
        List<SysMenu> flat = menuMapper.selectMenuByUserId(userId);

        // 2. 转成 VO 列表
        List<MenuTreeVO> vos = flat.stream().map(menu -> {
            MenuTreeVO vo = new MenuTreeVO();
            BeanUtils.copyProperties(menu, vo, "menuId", "parentId", "sortOrder");
            vo.setId(menu.getId());
            vo.setSortOrder(menu.getOrderNum());
            vo.setChildren(new ArrayList<>());
            return vo;
        }).collect(Collectors.toList());

        // 3. 构建树
        Map<Long, MenuTreeVO> map = vos.stream()
                .collect(Collectors.toMap(MenuTreeVO::getId, v -> v));

        List<MenuTreeVO> tree = new ArrayList<>();
        for (MenuTreeVO node : vos) {
            Long parentId = flat.stream()
                    .filter(m -> m.getId().equals(node.getId()))
                    .findFirst()
                    .map(SysMenu::getParentId)
                    .orElse(0L);

            if (parentId != null && parentId != 0 && map.containsKey(parentId)) {
                map.get(parentId).getChildren().add(node);
            } else {
                tree.add(node);
            }
        }

        // 4. 对每个层级按 sortOrder 排序
        sortTree(tree);
        return tree;
    }

    private void sortTree(List<MenuTreeVO> nodes) {
        nodes.sort(Comparator.comparing(MenuTreeVO::getSortOrder));
        for (MenuTreeVO n : nodes) {
            if (n.getChildren() != null && !n.getChildren().isEmpty()) {
                sortTree(n.getChildren());
            }
        }
    }
}
