package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.dto.SysRoleDTO;
import com.company.oa.entity.SysRole;
import com.company.oa.mapper.SysRoleMapper;
import com.company.oa.service.SysRoleService;
import com.company.oa.vo.SysRoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public Page<SysRoleVO> pageRoles(int page, int size) {
        Page<SysRole> pe = this.page(new Page<>(page, size));
        return (Page<SysRoleVO>) pe.convert(e -> {
            SysRoleVO vo = new SysRoleVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        });
    }

    @Override
    public SysRoleVO getRole(Long id) {
        SysRole e = this.getById(id);
        SysRoleVO vo = new SysRoleVO();
        BeanUtils.copyProperties(e, vo);
        return vo;
    }

    @Override
    public void createRole(SysRoleDTO dto) {
        SysRole e = new SysRole();
        BeanUtils.copyProperties(dto, e);
        this.save(e);
    }

    @Override
    public void updateRole(Long id, SysRoleDTO dto) {
        SysRole e = new SysRole();
        BeanUtils.copyProperties(dto, e);
        e.setId(id);
        this.updateById(e);
    }

    @Override
    public void deleteRole(Long id) {
        this.removeById(id);
    }
}