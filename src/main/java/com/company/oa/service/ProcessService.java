package com.company.oa.service;

import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import java.util.List;
import java.util.Map;

public interface ProcessService {
    // 启动一个流程实例，返回流程实例ID
    ProcessInstance startProcess(String processKey, String businessKey, Map<String, Object> vars);

    // 查询某人待办任务列表
    List<Task> getUserTasks(String assignee);

    // 完成某个任务，传入任务ID和审批变量
    void completeTask(String taskId, Map<String, Object> vars);
}
