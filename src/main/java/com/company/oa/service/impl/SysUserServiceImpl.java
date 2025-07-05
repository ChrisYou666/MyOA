package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.entity.SysUser;
import com.company.oa.mapper.SysUserMapper;
import com.company.oa.dto.SysUserDTO;
import com.company.oa.service.SysUserService;
import com.company.oa.vo.SysUserVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.stream.Collectors;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public Page<SysUserVO> pageUsers(int page, int size) {
        Page<SysUser> p = this.page(new Page<>(page, size));
        Page<SysUserVO> voPage = new Page<>(p.getCurrent(), p.getSize(), p.getTotal());
        voPage.setRecords(p.getRecords().stream().map(entity -> {
            SysUserVO vo = new SysUserVO();
            BeanUtils.copyProperties(entity, vo);
            // TODO: 查询并设置 deptName
            return vo;
        }).collect(Collectors.toList()));
        return voPage;
    }

    @Override
    public SysUserVO getUser(Long id) {
        SysUser e = this.getById(id);
        SysUserVO vo = new SysUserVO();
        BeanUtils.copyProperties(e, vo);
        // TODO: 填充 deptName
        return vo;
    }

    @Override
    public void createUser(SysUserDTO dto) {
        SysUser e = new SysUser();
        BeanUtils.copyProperties(dto, e);
        this.save(e);
    }

    @Override
    public void updateUser(Long id, SysUserDTO dto) {
        SysUser e = new SysUser();
        BeanUtils.copyProperties(dto, e);
        e.setId(id);
        this.updateById(e);
    }

    @Override
    public void deleteUser(Long id) {
        this.removeById(id);
    }
}