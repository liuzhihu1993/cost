package com.fh.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.bean.ExpenseAccount;
import com.fh.bean.UserInfo;
import com.fh.util.ProcessUtils;

/**
 * 请假管理的控制器 (activiti工作流)
 * 
 * @author 风华项目组出品
 * 
 */
@Controller
public class ExpenseActivitConterller
{
    
    // 流程引擎对象
    @Autowired
    private ProcessEngine pe;
    
    /**
     * 加载报销单页面
     * 
     * @return
     */
    @RequestMapping("/expa/loadadd.do")
    public String loadadd()
    {
        
        return "expa/expa_add";
    }
    
    /**
     * 添加报销单
     * 
     * @param ea 报销单详细信息
     * @param model
     * @return
     */
    @RequestMapping("/expa/add.do")
    public String add(HttpSession session, ExpenseAccount ea, Model model)
    {
        
        try
        {
            
            // 启动流程实例
            ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey(ProcessUtils.PROCESS_DEFINITON_EKY);
            
            // 获取流程实例Id
            String processInstanceId = pi.getProcessInstanceId();
            // 获取任务管理
            TaskService ts = pe.getTaskService();
            
            // 查询任务
            Task task = ts.createTaskQuery().taskAssignee(ProcessUtils.PROCESS_ASSIGNEE_USER)// 指定任务办理者
                .processInstanceId(processInstanceId)
                // 指定流程实例ID
                .singleResult();
            
            // 获取当前登陆用户信息
            UserInfo user = (UserInfo)session.getAttribute("user");
            if (ea != null)
            {
                ea.setUserId(user.getUserId());
                ea.setUserName(user.getUserName());
            }
            // 设置流程变量
            ts.setVariable(task.getId(), ProcessUtils.VARIABLE_NAME, ea);
            
            // 完成任务
            ts.complete(task.getId());
            
            //
            model.addAttribute("info", "报销单提交成功!");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return "expa/expa_add";
    }
    
    /**
     * 查询任务信息
     * 
     * @param type 办理者
     * @param model
     * @return
     */
    @RequestMapping("/expa/list.do")
    public String list(String type, Model model)
    {
        // 任务办理者
        String assignee = type;
        
        // 查询任务
        List<Task> tlist = pe.getTaskService().createTaskQuery().taskAssignee(assignee).list();
        
        // 任务管理的service
        TaskService ts = pe.getTaskService();
        
        if (tlist != null && tlist.size() > 0)
        {
            List<Map> list = new ArrayList<Map>();
            
            for (Task task : tlist)
            {
                Map map = new HashMap();
                map.put("taskId", task.getId());
                map.put("createTime", task.getCreateTime());
                // 获取流程变量信息
                ExpenseAccount ea = (ExpenseAccount)ts.getVariable(task.getId(), ProcessUtils.VARIABLE_NAME);
                
                map.put(ProcessUtils.VARIABLE_NAME, ea);
                
                list.add(map);
                
            }
            
            model.addAttribute("list", list);
            
        }
        
        if (ProcessUtils.PROCESS_ASSIGNEE_MANAGER.equals(assignee))
        {
            assignee = "经理审核";
        }
        else if (ProcessUtils.PROCESS_ASSIGNEE_FINANCE.equals(assignee))
        {
            assignee = "财务审核";
        }
        
        model.addAttribute("assignee", assignee);
        model.addAttribute("type", type);
        
        return "expa/expa_list";
    }
    
    /**
     * 查询任务信息
     * 
     * @param type 办理者
     * @param model
     * @return
     */
    @RequestMapping("/expa/mylist.do")
    public String mylist(HttpSession session, Model model)
    {
        
        // 获取当前登陆用户信息
        UserInfo user = (UserInfo)session.getAttribute("user");
        
        // 查询任务
        List<Task> tlist =
            pe.getTaskService().createTaskQuery().taskAssignee(ProcessUtils.PROCESS_ASSIGNEE_USER).list();
        
        // 任务管理的service
        TaskService ts = pe.getTaskService();
        
        if (tlist != null && tlist.size() > 0)
        {
            List<Map> list = new ArrayList<Map>();
            
            for (Task task : tlist)
            {
                Map map = new HashMap();
                map.put("taskId", task.getId());
                map.put("createTime", task.getCreateTime());
                // 获取流程变量信息
                ExpenseAccount ea = (ExpenseAccount)ts.getVariable(task.getId(), ProcessUtils.VARIABLE_NAME);
                
                map.put(ProcessUtils.VARIABLE_NAME, ea);
                
                if (user.getUserId().equals(ea.getUserId()))
                {
                    list.add(map);
                }
                
            }
            
            model.addAttribute("list", list);
            
        }
        
        return "expa/expa_mylist";
    }
    
    /**
     * 加载经理审核页面
     * 
     * @param taskId
     * @param model
     * @return
     */
    @RequestMapping("/expa/loadManager.do")
    public String loadManager(String taskId, Date createTime, Model model)
    {
        // 任务管理的service
        TaskService ts = pe.getTaskService();
        
        // 获取流程变量信息
        ExpenseAccount ea = (ExpenseAccount)ts.getVariable(taskId, ProcessUtils.VARIABLE_NAME);
        
        model.addAttribute("expa", ea);
        model.addAttribute("taskId", taskId);
        model.addAttribute("createTime", createTime);
        
        return "expa/expa_manager_audit";
    }
    
    /**
     * 经理审核信息
     * 
     * @param session
     * @param ea
     * @param model
     * @return
     */
    @RequestMapping("/expa/managerAudit.do")
    public String managerAudit(HttpSession session, String taskId, ExpenseAccount ea, Model model)
    {
        
        try
        {
            // 获取当前登陆用户信息
            UserInfo user = (UserInfo)session.getAttribute("user");
            System.out.println(taskId);
            // 任务管理的service
            TaskService ts = pe.getTaskService();
            ExpenseAccount exp = (ExpenseAccount)ts.getVariable(taskId, ProcessUtils.VARIABLE_NAME);
            System.out.println("11111:" + exp);
            if (exp != null)
            {
                exp.setManagerMark(ea.getManagerMark());
                exp.setManagerDesc(ea.getManagerDesc());
                exp.setManagerId(user.getUserId());
                exp.setManagerName(user.getUserName());
            }
            
            // 重新设置流程变量
            ts.setVariable(taskId, ProcessUtils.VARIABLE_NAME, exp);
            
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("managerMark", ea.getManagerMark());
            
            // 完成任务
            ts.complete(taskId, variables);
            
            // 提示信息
            model.addAttribute("info", "经理审批完毕！");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return list(ProcessUtils.PROCESS_ASSIGNEE_MANAGER, model);
        
    }
    
    /**
     * 加载报销单页面
     * 
     * @return
     */
    @RequestMapping("/expa/loadmyExpa.do")
    public String loadmyExpa(String taskId, Date createTime, Model model)
    {
        
        // 任务管理的service
        TaskService ts = pe.getTaskService();
        
        // 获取流程变量信息
        ExpenseAccount ea = (ExpenseAccount)ts.getVariable(taskId, ProcessUtils.VARIABLE_NAME);
        System.out.println(ea.getManagerMark());
        System.out.println(ea.getManagerDesc());
        model.addAttribute("expa", ea);
        model.addAttribute("taskId", taskId);
        model.addAttribute("createTime", createTime);
        
        return "expa/expa_myadd";
    }
    
    /**
     * 重新提交报销单
     * 
     * @param taskId
     * @param ea
     * @param model
     * @return
     */
    @RequestMapping("/expa/readd.do")
    public String readd(HttpSession session, String taskId, ExpenseAccount ea, Model model)
    {
        
        try
        {
            // 任务管理的service
            TaskService ts = pe.getTaskService();
            // 获取当前登陆用户信息
            UserInfo user = (UserInfo)session.getAttribute("user");
            if (ea != null)
            {
                ea.setUserId(user.getUserId());
                ea.setUserName(user.getUserName());
            }
            // 重新设置流程变量
            ts.setVariable(taskId, ProcessUtils.VARIABLE_NAME, ea);
            
            // 完成任务
            ts.complete(taskId);
            
            model.addAttribute("info", "请假单提交成功!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return mylist(session, model);
    }
    
    /**
     * 加载财务审核页面
     * 
     * @param taskId
     * @param model
     * @return
     */
    @RequestMapping("/expa/loadFinance.do")
    public String loadFinance(String taskId, Date createTime, Model model)
    {
        // 任务管理的service
        TaskService ts = pe.getTaskService();
        
        // 获取流程变量信息
        ExpenseAccount ea = (ExpenseAccount)ts.getVariable(taskId, ProcessUtils.VARIABLE_NAME);
        
        model.addAttribute("expa", ea);
        model.addAttribute("taskId", taskId);
        model.addAttribute("createTime", createTime);
        
        return "expa/expa_finance_audit";
    }
    
    /**
     * 财务审核信息
     * 
     * @param session
     * @param ea
     * @param model
     * @return
     */
    @RequestMapping("/expa/financeAudit.do")
    public String financeAudit(HttpSession session, String taskId, ExpenseAccount ea, Model model)
    {
        
        try
        {
            // 获取当前登陆用户信息
            UserInfo user = (UserInfo)session.getAttribute("user");
            System.out.println(taskId);
            // 任务管理的service
            TaskService ts = pe.getTaskService();
            ExpenseAccount exp = (ExpenseAccount)ts.getVariable(taskId, ProcessUtils.VARIABLE_NAME);
            
            if (exp != null)
            {
                exp.setFinanceId(user.getUserId());
                exp.setFinanceName(user.getUserName());
                exp.setFinanceMark(ea.getFinanceMark());
                exp.setFinanceDesc(ea.getFinanceDesc());
            }
            
            // 重新设置流程变量
            ts.setVariable(taskId, ProcessUtils.VARIABLE_NAME, exp);
            
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("financeMark", ea.getFinanceMark());
            
            // 完成任务
            ts.complete(taskId, variables);
            
            // 提示信息
            model.addAttribute("info", "财务审批完毕！");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return list(ProcessUtils.PROCESS_ASSIGNEE_FINANCE, model);
        
    }
    
    /**
     * 查询所有的报销单
     * 
     * @param model
     * @return
     */
    @RequestMapping("/expa/hisList.do")
    public String hisList(Model model)
    {
        
        // 获取历史流程实例信息
        List<HistoricProcessInstance> list =
            pe.getHistoryService()
                .createHistoricProcessInstanceQuery()
                .processDefinitionKey(ProcessUtils.PROCESS_DEFINITON_EKY)
                .orderByProcessInstanceStartTime()
                .desc()
                .list();
        
        if (list != null && list.size() > 0)
        {
            
            List<Map> tlist = new ArrayList<Map>();
            
            for (HistoricProcessInstance hpi : list)
            {
                Map map = new HashMap();
                map.put("processInstanceId", hpi.getId());
                map.put("processDefinitionId", hpi.getProcessDefinitionId());
                map.put("startTime", hpi.getStartTime());
                map.put("endTime", hpi.getEndTime());
                if (hpi.getEndTime() != null)
                {
                    map.put("mark", "1");// 执行完毕
                }
                else
                {
                    map.put("mark", "2");// 执行中
                }
                
                // 查询流程变量信息
                List<HistoricVariableInstance> hvlist =
                    pe.getHistoryService().createHistoricVariableInstanceQuery().processInstanceId(hpi.getId()).list();
                if (hvlist != null)
                {
                    for (HistoricVariableInstance hvi : hvlist)
                    {
                        map.put(hvi.getVariableName(), hvi.getValue());
                    }
                }
                tlist.add(map);
            }
            model.addAttribute("tlist", tlist);
            
        }
        
        return "expa/expa_his_list";
    }
    
    /**
     * 查询我的报销单
     * 
     * @param model
     * @return
     */
    @RequestMapping("/expa/hisMyList.do")
    public String hisMyList(HttpSession session, Model model)
    {
        
        // 获取历史流程实例信息
        List<HistoricProcessInstance> list =
            pe.getHistoryService()
                .createHistoricProcessInstanceQuery()
                .processDefinitionKey(ProcessUtils.PROCESS_DEFINITON_EKY)
                .orderByProcessInstanceStartTime()
                .desc()
                .list();
        
        if (list != null && list.size() > 0)
        {
            
            List<Map> tlist = new ArrayList<Map>();
            
            for (HistoricProcessInstance hpi : list)
            {
                Map map = new HashMap();
                map.put("processInstanceId", hpi.getId());
                map.put("processDefinitionId", hpi.getProcessDefinitionId());
                map.put("startTime", hpi.getStartTime());
                map.put("endTime", hpi.getEndTime());
                if (hpi.getEndTime() != null)
                {
                    map.put("mark", "1");// 执行完毕
                }
                else
                {
                    map.put("mark", "2");// 执行中
                }
                // 获取当前登陆用户信息
                UserInfo user = (UserInfo)session.getAttribute("user");
                
                // 查询流程变量信息
                List<HistoricVariableInstance> hvlist =
                    pe.getHistoryService().createHistoricVariableInstanceQuery().processInstanceId(hpi.getId()).list();
                if (hvlist != null)
                {
                    for (HistoricVariableInstance hvi : hvlist)
                    {
                        
                        if (hvi.getVariableName().equals(ProcessUtils.VARIABLE_NAME))
                        {
                            ExpenseAccount eaa = (ExpenseAccount)hvi.getValue();
                            if (user.getUserId().equals(eaa.getUserId()))
                            {
                                map.put(hvi.getVariableName(), hvi.getValue());
                                tlist.add(map);
                            }
                        }
                        
                    }
                }
                
            }
            model.addAttribute("tlist", tlist);
            
        }
        
        return "expa/expa_his_my_list";
    }
    
    /**
     * 查看当前流程位置
     * 
     * @param processDefinitionId
     * @param processInstanceId
     * @param model
     * @return
     */
    @RequestMapping("/expa/showImg.do")
    public String showImg(String processDefinitionId, String processInstanceId, Model model)
    {
        
        ActivityImpl actimpl = null;
        try
        {
            
            actimpl = ProcessUtils.getProcessMap(processDefinitionId, processInstanceId);
            
            model.addAttribute("actimpl", actimpl);
            // 返回流程定义Id到页面
            model.addAttribute("processDefinitionId", processDefinitionId);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return "expa/expa_img";
    }
    
    /**
     * 获取流程图片
     * 
     * @param processDefinitionId
     * @param response
     */
    @RequestMapping("/expa/findImg.do")
    public void findImg(String processDefinitionId, HttpServletResponse response)
    {
        
        try
        {
            
            InputStream img = ProcessUtils.findProcessImg(processDefinitionId);
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = img.read(buf, 0, 1024)) != -1)
            {
                response.getOutputStream().write(buf, 0, len);
            }
            img.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("获取图片失败");
        }
    }
    
}
