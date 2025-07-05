package com.company.oa.controller;


import com.company.oa.common.R;
import com.company.oa.dto.SysPostDTO;
import com.company.oa.vo.SysPostVO;
import com.company.oa.service.SysPostService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class SysPostController {

    @Autowired
    private SysPostService postService;

    @GetMapping
    @PreAuthorize("hasAuthority('MENU_POST_VIEW')")
    public R<Page<SysPostVO>> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return R.ok(postService.pagePosts(page, size));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('MENU_POST_VIEW')")
    public R<SysPostVO> get(@PathVariable Long id) {
        return R.ok(postService.getPost(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('MENU_POST_ADD')")
    public R<Void> create(@RequestBody @Valid SysPostDTO dto) {
        postService.createPost(dto);
        return R.ok();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('MENU_POST_EDIT')")
    public R<Void> update(@PathVariable Long id, @RequestBody @Valid SysPostDTO dto) {
        postService.updatePost(id, dto);
        return R.ok();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('MENU_POST_DELETE')")
    public R<Void> delete(@PathVariable Long id) {
        postService.deletePost(id);
        return R.ok();
    }
}