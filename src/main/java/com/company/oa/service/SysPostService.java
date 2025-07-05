package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.SysPostDTO;
import com.company.oa.entity.SysPost;
import com.company.oa.mapper.SysPostMapper;
import com.company.oa.vo.SysPostVO;

public interface SysPostService extends IService<SysPost> {
    Page<SysPostVO> pagePosts(int page, int size);
    SysPostVO getPost(Long id);
    void createPost(SysPostDTO dto);
    void updatePost(Long id, SysPostDTO dto);
    void deletePost(Long id);
}
