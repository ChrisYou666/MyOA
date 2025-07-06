package com.company.oa.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysDocumentVersionVO {
    private Long id;
    private Integer versionNo;
    private String filePath;
    private Long fileSize;
    private String mimeType;
    private Long uploadedBy;
    private LocalDateTime uploadedTime;
}