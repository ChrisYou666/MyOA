package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.oa.entity.SysUser;
import com.company.oa.mapper.SysUserMapper;
import com.company.oa.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired private SysPermissionService permService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = userMapper.selectOne(
                new QueryWrapper<SysUser>().eq("username", username)
        );
        if (user == null) throw new UsernameNotFoundException("用户不存在");

        // 加载权限编码列表
        List<String> codes = permService.getPermissionCodesByUser(user.getId());
        List<GrantedAuthority> auths = codes.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.getStatus()==1,
                true, true, true, auths
        );
    }
}
