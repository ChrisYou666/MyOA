package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SysDocumentVersionDTO {
    @NotNull
    private Long uploadedBy;
    @NotBlank
    private String filePath;
    @NotNull private Long fileSize;
    private String mimeType;
}