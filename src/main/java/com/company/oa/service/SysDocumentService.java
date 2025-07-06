package com.company.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.oa.dto.SysDocumentDTO;
import com.company.oa.dto.SysDocumentVersionDTO;
import com.company.oa.entity.SysDocument;
import com.company.oa.vo.SysDocumentVO;
import com.company.oa.vo.SysDocumentVersionVO;

import java.util.List;

public interface SysDocumentService {
    Long createDocument(SysDocumentDTO dto);
    void updateDocument(Long id, SysDocumentDTO dto);
    void deleteDocument(Long id);
    Page<SysDocumentVO> pageDocuments(int page, int size);
    Long addVersion(Long documentId, SysDocumentVersionDTO dto);
    List<SysDocumentVersionVO> listVersions(Long documentId);
}