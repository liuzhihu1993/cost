package com.fh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 流程定义管理控制器
 * 
 * @author 风华项目组出品
 * 
 */
@Controller
public class ProcessDefinitonController
{
    // 获取流程引擎对象
    @Autowired
    private ProcessEngine pe;
    
    /**
     * 加载流程部署页面
     * 
     * @return
     */
    @RequestMapping("/processdefin/loadAdd.do")
    public String loadAdd()
    {
        
        return "processdefin/processdefin_add";
    }
    
    /**
     * 部署流程定义
     * 
     * @param file 上传文件
     * @param name 流程名称
     * @param model
     * @return
     */
    @RequestMapping("/processdefin/deployZip.do")
    public String deployZip(@RequestParam(value = "file", required = false)
    MultipartFile file, String name, Model model)
    {
        
        try
        {
            
            // 获取上传文件
            ZipInputStream zis = new ZipInputStream(file.getInputStream());
            
            // 获取仓库服务service
            Deployment deployment = pe.getRepositoryService().createDeployment().name(name)// 指定流程的名称
                .addZipInputStream(zis)
                .deploy();
            
            if (deployment != null && deployment.getId() != null)
            {
                
                model.addAttribute("info", "【" + name + "】流程部署成功");
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return "processdefin/processdefin_add";
    }
    
    /**
     * 查询最新版本的流程定义
     * 
     * @param model
     * @return
     */
    @RequestMapping("/processdefin/list.do")
    public String list(Model model)
    {
        
        List<ProcessDefinition> list = pe.getRepositoryService()// 创建仓库服务
            .createProcessDefinitionQuery()
            // 创建流程定义查询对象
            .orderByProcessDefinitionVersion()
            .asc()
            // 根据版本排序
            .list();
        
        // 过滤最新版本
        Map<String, ProcessDefinition> map = new HashMap<String, ProcessDefinition>();
        if (list != null && list.size() > 0)
        {
            for (ProcessDefinition pd : list)
            {
                map.put(pd.getKey(), pd);
            }
        }
        
        // 遍历Map
        // 重新创建list
        list = new ArrayList<ProcessDefinition>();
        for (ProcessDefinition pd : map.values())
        {
            list.add(pd);
        }
        
        model.addAttribute("list", list);
        
        return "processdefin/processdefin_list";
    }
    
}
