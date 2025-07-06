package com.company.oa.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class SysAnnouncementDTO {
    @NotBlank private String title;
    @NotBlank private String content;
}