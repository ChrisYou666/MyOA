package com.company.oa.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysDocumentDTO {
    @NotBlank
    private String title;
    private String description;
}
