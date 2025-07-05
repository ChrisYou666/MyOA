package com.company.oa.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.SysRoleDTO;
import com.company.oa.entity.SysRole;
import com.company.oa.vo.SysRoleVO;

public interface SysRoleService extends IService<SysRole> {
    Page<SysRoleVO> pageRoles(int page, int size);
    SysRoleVO getRole(Long id);
    void createRole(SysRoleDTO dto);
    void updateRole(Long id, SysRoleDTO dto);
    void deleteRole(Long id);
}
