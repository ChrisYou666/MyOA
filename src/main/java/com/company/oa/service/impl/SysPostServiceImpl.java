package com.company.oa.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.oa.dto.SysPostDTO;
import com.company.oa.entity.SysPost;
import com.company.oa.mapper.SysPostMapper;
import com.company.oa.service.SysPostService;
import com.company.oa.vo.SysPostVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostService {
    @Override
    public Page<SysPostVO> pagePosts(int page, int size) {
        Page<SysPost> pe = this.page(new Page<>(page, size));
        return (Page<SysPostVO>) pe.convert(e -> {
            SysPostVO vo = new SysPostVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        });
    }

    @Override
    public SysPostVO getPost(Long id) {
        SysPost e = this.getById(id);
        SysPostVO vo = new SysPostVO();
        BeanUtils.copyProperties(e, vo);
        return vo;
    }

    @Override
    public void createPost(SysPostDTO dto) {
        SysPost e = new SysPost();
        BeanUtils.copyProperties(dto, e);
        this.save(e);
    }

    @Override
    public void updatePost(Long id, SysPostDTO dto) {
        SysPost e = new SysPost();
        BeanUtils.copyProperties(dto, e);
        e.setId(id);
        this.updateById(e);
    }

    @Override
    public void deletePost(Long id) {
        this.removeById(id);
    }
}
