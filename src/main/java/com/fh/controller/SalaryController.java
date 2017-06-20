package com.fh.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fh.bean.SalaryPayment;
import com.fh.bean.UserInfo;
import com.fh.service.SalaryPaymentService;
import com.fh.service.UserInfoService;
import com.fh.util.Constant;
import com.fh.util.Page;

/**
 * 薪资管理的控制器
 * 
 * @author 风华项目组出品
 * 
 */
@Controller
public class SalaryController extends Page
{
    
    /**
     * 用户管理的service
     */
    @Autowired
    private UserInfoService userservice;
    
    /**
     * 薪资管理的service
     */
    @Autowired
    private SalaryPaymentService spservice;
    
    /**
     * 加载薪资发放页面
     * 
     * @return
     */
    @RequestMapping("/salary/loadadd.do")
    public String loadadd(Model model)
    {
        
        UserInfo user = new UserInfo();
        user.setUserMark(Constant.ROLE_MARK_YES);
        user.setStart(-1);
        
        // 查询所有用户信息（企业员工信息）
        List<UserInfo> userlist = userservice.list(user);
        model.addAttribute("userlist", userlist);
        
        return "salary/salary_add";
    }
    
    /**
     * 添加薪资发放信息
     * 
     * @param sp
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/salary/add.do")
    public String add(SalaryPayment sp, Model model, HttpSession session)
    {
        
        try
        {
            spservice.add(sp);
            model.addAttribute("errorinfo", "薪资发放成功！");
        }
        catch (Exception e)
        {
            model.addAttribute("errorinfo", "薪资发放失败！");
        }
        
        return loadadd(model);
    }
    
    /**
     * 查询薪资发放信息
     * 
     * @param sp
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/salary/list.do")
    public String list(SalaryPayment sp, HttpServletRequest request, Model model)
    {
        
        if (sp == null)
        {
            sp = new SalaryPayment();
        }
        // 分页信息
        this.initPage(request);
        // 起始记录
        sp.setStart(this.getPageNo());
        // 每页显示记录数
        sp.setLength(Constant.PAGE_NUM_BIG);
        model.addAttribute("list", spservice.list(sp));
        // 总记录数
        model.addAttribute("total", spservice.getcount(sp));
        model.addAttribute("salaryPayment", sp);
        
        return "salary/salary_list";
    }
    
    /**
     * 导入Excel中数据
     * 
     * @param sp
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/salary/impexcel.do")
    public String impExcel(@RequestParam(value = "file", required = false)
    MultipartFile file, HttpServletRequest request, Model model)
    {
        try
        {
            // 上传文件
            // file.transferTo(targerfile);
            System.out.println(file.getSize());
            spservice.addAll(file.getInputStream());
            model.addAttribute("errorinfo", "导入成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("errorinfo", "导入失败");
        }
        return list(null, request, model);
    }
    
    /**
     * 时间属性的编辑器
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin)
    {
        bin.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    
}
