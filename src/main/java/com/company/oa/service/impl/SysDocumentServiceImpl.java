package com.company.oa.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.oa.common.ResourceNotFoundException;
import com.company.oa.dto.SysDocumentDTO;
import com.company.oa.dto.SysDocumentVersionDTO;
import com.company.oa.entity.SysDocument;
import com.company.oa.entity.SysDocumentVersion;
import com.company.oa.mapper.SysDocumentMapper;
import com.company.oa.mapper.SysDocumentVersionMapper;
import com.company.oa.service.SysDocumentService;
import com.company.oa.vo.SysDocumentVO;
import com.company.oa.vo.SysDocumentVersionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysDocumentServiceImpl implements SysDocumentService {
    @Autowired private SysDocumentMapper docMapper;
    @Autowired private SysDocumentVersionMapper verMapper;

    @Override
    public Long createDocument(SysDocumentDTO dto) {
        SysDocument doc = new SysDocument();
        BeanUtils.copyProperties(dto, doc);
        doc.setCreatedTime(LocalDateTime.now());
        doc.setUpdatedTime(LocalDateTime.now());
        docMapper.insert(doc);
        return doc.getId();
    }

    @Override
    public void updateDocument(Long id, SysDocumentDTO dto) {
        SysDocument doc = docMapper.selectById(id);
        if (doc == null) throw new ResourceNotFoundException("文档不存在: " + id);
        BeanUtils.copyProperties(dto, doc);
        doc.setUpdatedTime(LocalDateTime.now());
        docMapper.updateById(doc);
    }

    @Override
    public void deleteDocument(Long id) {
        docMapper.deleteById(id);
    }

    @Override
    public Page<SysDocumentVO> pageDocuments(int page, int size) {
        Page<SysDocument> p = docMapper.selectPage(new Page<>(page, size), null);
        Page<SysDocumentVO> voPage = new Page<>(p.getCurrent(), p.getSize(), p.getTotal());
        List<SysDocumentVO> voList = p.getRecords().stream().map(doc -> {
            SysDocumentVO vo = new SysDocumentVO();
            BeanUtils.copyProperties(doc, vo);
            return vo;
        }).collect(Collectors.toList());
        voPage.setRecords(voList);
        return voPage;
    }

    @Override
    public Long addVersion(Long documentId, SysDocumentVersionDTO dto) {
        SysDocument doc = docMapper.selectById(documentId);
        if (doc == null) throw new ResourceNotFoundException("文档不存在: " + documentId);
        SysDocumentVersion ver = new SysDocumentVersion();
        BeanUtils.copyProperties(dto, ver);
        ver.setDocumentId(documentId);
        Integer maxVer = verMapper.selectOne(
                Wrappers.<SysDocumentVersion>lambdaQuery()
                        .eq(SysDocumentVersion::getDocumentId, documentId)
                        .select(SysDocumentVersion::getVersionNo)
                        .orderByDesc(SysDocumentVersion::getVersionNo)
                        .last("LIMIT 1")
        ) != null ? verMapper.selectOne(
                Wrappers.<SysDocumentVersion>lambdaQuery()
                        .eq(SysDocumentVersion::getDocumentId, documentId)
                        .select(SysDocumentVersion::getVersionNo)
                        .orderByDesc(SysDocumentVersion::getVersionNo)
                        .last("LIMIT 1")
        ).getVersionNo() : 0;
        ver.setVersionNo(maxVer + 1);
        ver.setUploadedTime(LocalDateTime.now());
        verMapper.insert(ver);
        return ver.getId();
    }

    @Override
    public List<SysDocumentVersionVO> listVersions(Long documentId) {
        return verMapper.selectList(
                Wrappers.<SysDocumentVersion>lambdaQuery()
                        .eq(SysDocumentVersion::getDocumentId, documentId)
        ).stream().map(ver -> {
            SysDocumentVersionVO vo = new SysDocumentVersionVO();
            BeanUtils.copyProperties(ver, vo);
            return vo;
        }).collect(Collectors.toList());
    }
}