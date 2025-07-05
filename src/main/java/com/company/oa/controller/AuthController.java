package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.LoginDTO;
import com.company.oa.service.impl.CustomUserDetailsService;
import com.company.oa.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired private CustomUserDetailsService userDetailsSvc;

    @PostMapping("/login")
    public R<String> login(@RequestBody LoginDTO dto) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        Authentication auth = authManager.authenticate(token);

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        // 额外把权限列表放进 token 里
        Map<String,Object> claims = Collections.singletonMap(
                "authorities",
                userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList())
        );
        String jwt = JwtUtil.generateToken(userDetails.getUsername(), claims);
        return R.ok(jwt);
    }
}