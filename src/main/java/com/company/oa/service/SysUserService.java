package com.company.oa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.SysUserDTO;
import com.company.oa.entity.SysUser;
import com.company.oa.mapper.SysUserMapper;
import com.company.oa.vo.SysUserVO;

import java.util.List;
import com.company.oa.common.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface SysUserService extends IService<SysUser>{
    Page<SysUserVO> pageUsers(int page, int size);
    SysUserVO getUser(Long id);
    void createUser(SysUserDTO dto);
    void updateUser(Long id, SysUserDTO dto);
    void deleteUser(Long id);
}
