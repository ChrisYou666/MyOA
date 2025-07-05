package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.service.ProcessService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/process")
public class ProcessController {

    @Autowired private ProcessService processService;

    /**
     * 启动流程
     * @param processKey leaveProcess/reimburseProcess/travelProcess/overtimeProcess
     * @param businessKey 业务表ID
     * @param vars 流程变量，如 initiator, manager, financeApprover
     */
    @PostMapping("/start/{processKey}/{businessKey}")
    public R<String> start(
            @PathVariable String processKey,
            @PathVariable String businessKey,
            @RequestBody Map<String,Object> vars) {

        ProcessInstance pi = processService.startProcess(processKey, businessKey, vars);
        return R.ok(pi.getId());
    }

    /** 查询当前用户的待办任务 */
    @GetMapping("/tasks/{assignee}")
    public R<List<Task>> tasks(@PathVariable String assignee) {
        List<Task> list = processService.getUserTasks(assignee);
        return R.ok(list);
    }

    /** 完成任务 */
    @PostMapping("/complete/{taskId}")
    public R<Void> complete(
            @PathVariable String taskId,
            @RequestBody(required = false) Map<String,Object> vars) {
        processService.completeTask(taskId, vars);
        return R.ok();
    }
}