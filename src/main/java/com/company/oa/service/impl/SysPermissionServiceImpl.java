package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.entity.*;
import com.company.oa.mapper.*;
import com.company.oa.dto.SysPermissionDTO;
import com.company.oa.vo.SysPermissionVO;
import com.company.oa.service.SysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysPermissionServiceImpl
        extends ServiceImpl<SysPermissionMapper, SysPermission>
        implements SysPermissionService {

    private final SysUserRoleMapper userRoleMapper;
    private final SysRoleMenuMapper roleMenuMapper;
    private final SysRolePermissionMapper rolePermMapper;
    private final SysPermissionMapper sysPermissionMapper;

    public SysPermissionServiceImpl(
            SysUserRoleMapper ur,
            SysRoleMenuMapper rm,
            SysRolePermissionMapper rp,
            SysPermissionMapper sysPermissionMapper
    ) {
        this.userRoleMapper = ur;
        this.roleMenuMapper = rm;
        this.rolePermMapper = rp;
        this.sysPermissionMapper = sysPermissionMapper;
    }

    // 粗粒度
    @Override
    public List<Long> getUserRoleIds(Long userId) {
        return userRoleMapper.selectList(
                new QueryWrapper<SysUserRole>().eq("user_id", userId)
        ).stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
    }
    @Override @Transactional
    public void assignRolesToUser(Long userId, List<Long> roleIds) {
        userRoleMapper.delete(
                new QueryWrapper<SysUserRole>().eq("user_id", userId)
        );
        roleIds.forEach(rid -> {
            SysUserRole ur = new SysUserRole();
            ur.setUserId(userId); ur.setRoleId(rid);
            userRoleMapper.insert(ur);
        });
    }
    @Override
    public List<Long> getRoleMenuIds(Long roleId) {
        return roleMenuMapper.selectList(
                new QueryWrapper<SysRoleMenu>().eq("role_id", roleId)
        ).stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
    }
    @Override @Transactional
    public void assignMenusToRole(Long roleId, List<Long> menuIds) {
        roleMenuMapper.delete(
                new QueryWrapper<SysRoleMenu>().eq("role_id", roleId)
        );
        menuIds.forEach(mid -> {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(roleId); rm.setMenuId(mid);
            roleMenuMapper.insert(rm);
        });
    }

    // 细粒度：权限 CRUD
    @Override
    public Page<SysPermissionVO> pagePermissions(int page, int size) {
        Page<SysPermission> pe = this.page(new Page<>(page, size));
        return (Page<SysPermissionVO>) pe.convert(e -> {
            SysPermissionVO vo = new SysPermissionVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        });
    }
    @Override
    public SysPermissionVO getPermission(Long id) {
        SysPermission e = this.getById(id);
        SysPermissionVO vo = new SysPermissionVO();
        BeanUtils.copyProperties(e, vo);
        return vo;
    }
    @Override
    public void createPermission(SysPermissionDTO dto) {
        SysPermission e = new SysPermission();
        BeanUtils.copyProperties(dto, e);
        this.save(e);
    }
    @Override
    public void updatePermission(Long id, SysPermissionDTO dto) {
        SysPermission e = new SysPermission();
        BeanUtils.copyProperties(dto, e);
        e.setId(id);
        this.updateById(e);
    }
    @Override
    public void deletePermission(Long id) {
        this.removeById(id);
    }

    // 细粒度：角色-权限
    @Override
    public List<Long> getRolePermissionIds(Long roleId) {
        return rolePermMapper.selectList(
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<SysRolePermission>()
                        .eq("role_id", roleId)
        ).stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());
    }
    @Override @Transactional
    public void assignPermissionsToRole(Long roleId, List<Long> permissionIds) {
        rolePermMapper.delete(
                new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<SysRolePermission>()
                        .eq("role_id", roleId)
        );
        permissionIds.forEach(pid -> {
            SysRolePermission rp = new SysRolePermission();
            rp.setRoleId(roleId); rp.setPermissionId(pid);
            rolePermMapper.insert(rp);
        });
    }

    @Override
    public List<String> getPermissionCodesByUser(Long userId) {
        // 1) 查出用户所有角色 ID
        List<Long> roleIds = userRoleMapper.selectList(
                        new QueryWrapper<SysUserRole>().eq("user_id", userId)
                ).stream()
                .map(SysUserRole::getRoleId)
                .distinct()
                .collect(Collectors.toList());
        if (roleIds.isEmpty()) {
            return Collections.emptyList();
        }

        // 2) 根据角色 ID 查角色-权限关联，拿到所有 permissionId
        List<Long> permIds = rolePermMapper.selectList(
                        new QueryWrapper<SysRolePermission>()
                                .in("role_id", roleIds)
                ).stream()
                .map(SysRolePermission::getPermissionId)
                .distinct()
                .collect(Collectors.toList());
        if (permIds.isEmpty()) {
            return Collections.emptyList();
        }

        // 3) 根据 permissionId 查出所有 SysPermission 实体，并返回 code 列表
        return sysPermissionMapper.selectList(
                        new QueryWrapper<SysPermission>()
                                .in("id", permIds)
                                .eq("status", 1)    // 只返回启用的权限
                ).stream()
                .map(SysPermission::getCode)
                .collect(Collectors.toList());
    }
}