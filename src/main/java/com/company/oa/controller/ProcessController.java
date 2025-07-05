package com.company.oa.controller;

import com.company.oa.common.R;
import com.company.oa.dto.ProcessTaskDTO;
import com.company.oa.service.ProcessService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/process")
public class ProcessController {

    @Autowired private ProcessService processService;

    @Autowired
    private org.flowable.engine.RepositoryService repositoryService;

    @Autowired
    private org.flowable.engine.RuntimeService runtimeService;

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

    @GetMapping("/tasks/{assignee}")
    public R<List<ProcessTaskDTO>> tasks(@PathVariable String assignee) {
        List<Task> tasks = processService.getUserTasks(assignee);

        List<ProcessTaskDTO> dtos = tasks.stream().map(t -> {
            ProcessTaskDTO dto = new ProcessTaskDTO();
            dto.setTaskId(t.getId());
            dto.setName(t.getName());

            // 1) 取流程定义 Key
            String defId = t.getProcessDefinitionId();
            String defKey = repositoryService
                    .createProcessDefinitionQuery()
                    .processDefinitionId(defId)
                    .singleResult()
                    .getKey();
            dto.setProcessKey(defKey);

            // 2) 取当前节点的 ID（TaskDefinitionKey）
            dto.setNodeKey(t.getTaskDefinitionKey());

            // 3) 取业务 Key
            String instId = t.getProcessInstanceId();
            String busKey = runtimeService
                    .createProcessInstanceQuery()
                    .processInstanceId(instId)
                    .singleResult()
                    .getBusinessKey();
            dto.setBusinessKey(busKey);

            // 4) 创建时间
            dto.setCreateTime(t.getCreateTime());
            return dto;
        }).collect(Collectors.toList());

        return R.ok(dtos);
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