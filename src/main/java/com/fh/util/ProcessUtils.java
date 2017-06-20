package com.fh.util;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 流程相关的工具类
 * 
 * @author 风华项目组出品
 * 
 */
public class ProcessUtils
{
    // 流程定义的key
    public static final String PROCESS_DEFINITON_EKY = "ExpenseProcess";
    
    // 流程变量名称
    public static final String VARIABLE_NAME = "expa";
    
    // 任务办理者
    public static final String PROCESS_ASSIGNEE_USER = "user";
    
    public static final String PROCESS_ASSIGNEE_MANAGER = "manager";
    
    public static final String PROCESS_ASSIGNEE_FINANCE = "finance";
    
    /**
     * 获取流程引擎对象
     * 
     * @return
     */
    public static ProcessEngine getProcessEngine()
    {
        
        return ProcessEngines.getDefaultProcessEngine();
    }
    
    /**
     * 获取流程信息
     * 
     * @param processdefId 获取流程定义ID
     * @param executionId 获取流程实例信息
     * @return
     * @throws Exception
     */
    public static ActivityImpl getProcessMap(String processdefId, String executionId)
        throws Exception
    {
        // 仓库服务
        RepositoryService repositoryService = getProcessEngine().getRepositoryService();
        // 流程定义信息
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()// 创建流程定义的查询对象
            .processDefinitionId(processdefId)
            .singleResult();
        System.out.println("查看流程定义名称：" + processDefinition.getName());
        
        ProcessDefinitionImpl pdImpl = (ProcessDefinitionImpl)processDefinition;
        String processDefinitionId = pdImpl.getId();
        System.out.println("流程标识：" + processDefinitionId);
        
        ProcessDefinitionEntity def =
            (ProcessDefinitionEntity)((RepositoryServiceImpl)repositoryService).getDeployedProcessDefinition(processDefinitionId);
        ActivityImpl actimpl = null;
        
        RuntimeService runtimeService = getProcessEngine().getRuntimeService();
        ExecutionEntity execution =
            (ExecutionEntity)runtimeService.createExecutionQuery().executionId(executionId).singleResult();
        
        // 执行实例
        // 当前实例执行到那个节点
        String activityId = execution.getActivityId();
        System.out.println("当前执行节点：" + activityId);
        
        // 获取当前任务所有的节点
        List<ActivityImpl> list = def.getActivities();
        
        for (ActivityImpl impl : list)
        {
            String id = impl.getId();
            if (id.equals(activityId))
            {// 获取执行到那个节点
            
                actimpl = impl;
                break;
            }
        }
        
        return actimpl;
    }
    
    /**
     * 获取流程图片
     * 
     * @param processDefId 流程定义Id
     * @return
     */
    public static InputStream findProcessImg(String processDefId)
        throws Exception
    {
        // 仓库服务
        RepositoryService repositoryService = getProcessEngine().getRepositoryService();
        // 流程定义信息
        ProcessDefinition processDef = repositoryService.createProcessDefinitionQuery()// 创建流程定义的查询对象
            .processDefinitionId(processDefId)
            .singleResult();
        
        String name = processDef.getDiagramResourceName();
        InputStream is = repositoryService.getResourceAsStream(processDef.getDeploymentId(), name);
        
        return is;
    }
}
