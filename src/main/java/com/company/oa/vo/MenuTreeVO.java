package com.company.oa.vo;

import lombok.Data;
import java.util.List;

@Data
public class MenuTreeVO {
    private Long id;
    private String name;
    private String path;
    private String component;
    private String icon;
    private Integer sortOrder;
    private List<MenuTreeVO> children;
}
