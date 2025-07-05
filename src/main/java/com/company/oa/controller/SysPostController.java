package com.company.oa.controller;


import com.company.oa.common.R;
import com.company.oa.dto.SysPostDTO;
import com.company.oa.vo.SysPostVO;
import com.company.oa.service.SysPostService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class SysPostController {

    @Autowired
    private SysPostService postService;

    @GetMapping
    public R<Page<SysPostVO>> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(postService.pagePosts(page, size));
    }

    @GetMapping("/{id}")
    public R<SysPostVO> get(@PathVariable Long id) {
        return R.ok(postService.getPost(id));
    }

    @PostMapping
    public R<Void> create(@RequestBody @Valid SysPostDTO dto) {
        postService.createPost(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid SysPostDTO dto) {
        postService.updatePost(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        postService.deletePost(id);
        return R.ok();
    }
}