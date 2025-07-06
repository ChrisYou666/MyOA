package com.company.oa.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sys_document_version")
public class SysDocumentVersion {
    private Long id;
    private Long documentId;
    private Integer versionNo;
    private String filePath;
    private Long fileSize;
    private String mimeType;
    private Long uploadedBy;
    private LocalDateTime uploadedTime;
}