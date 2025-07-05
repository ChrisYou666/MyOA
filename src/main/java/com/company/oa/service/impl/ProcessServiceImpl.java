package com.company.oa.service.impl;

import com.company.oa.service.ProcessService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Override
    public ProcessInstance startProcess(String processKey, String businessKey, Map<String, Object> vars) {
        return runtimeService
                .startProcessInstanceByKey(processKey, businessKey, vars);
    }

    @Override
    public List<Task> getUserTasks(String assignee) {
        return taskService
                .createTaskQuery()
                .taskAssignee(assignee)
                .orderByTaskCreateTime().desc()
                .list();
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> vars) {
        taskService.complete(taskId, vars);
    }
}