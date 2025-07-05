package com.company.oa.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ProcessTaskDTO {
    private String taskId;
    private String name;
    private String processKey;
    private String nodeKey;
    private String businessKey;
    private Date createTime;
    // + getters/setters
}
