package com.fh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.bean.ExpenseAccount;
import com.fh.bean.UserInfo;
import com.fh.service.AnthorityService;
import com.fh.service.ExpenseService;
import com.fh.service.ReportService;
import com.fh.service.UserInfoService;
import com.fh.util.Constant;

/**
 * 用户登陆控制器
 * 
 * @author 风华项目组出品
 * 
 */
@Controller
public class LoginController
{
    
    /**
     * 用户管理的业务逻辑接口
     */
    @Autowired
    private UserInfoService userservice;
    
    /**
     * 权限管理的业务逻辑接口
     */
    @Autowired
    private AnthorityService anservice;
    
    /**
     * 报表管理业务逻辑接口
     */
    @Autowired
    private ReportService reportservice;
    
    /**
     * 报销管理的业务逻辑接口
     */
    @Autowired
    private ExpenseService expservice;
    
    /**
     * 用户登陆
     * 
     * @return
     */
    @RequestMapping("login.do")
    public String login(UserInfo user, HttpSession session, Model model)
    {
        
        UserInfo userinfo = userservice.isLogin(user);
        if (userinfo != null)
        {
            // 把当前用户存放到session中
            session.setAttribute("user", userinfo);
            
            // 查询用户对应的菜单信息
            List<Map> list = anservice.getMenuList(userinfo.getRoleId());
            session.setAttribute("menulist", list);
            
            return "main/index";
        }
        
        return "redirect:login.jsp";
    }
    
    @RequestMapping("bootm.do")
    public String bootm(Model model, HttpSession session)
    {
        
        // 经理审核
        boolean mmark = false;
        // 财务审核
        boolean finMafrk = false;
        // 报表
        boolean reportMark = false;
        List<Map> list = (List<Map>)session.getAttribute("menulist");
        if (list != null)
        {
            for (int i = 0; i < list.size(); i++)
            {
                Map map = list.get(i);
                
                int menuid = Integer.parseInt(map.get("menu_id").toString());
                if (menuid == 12)
                {
                    mmark = true;
                    break;
                }
            }
            
            for (int i = 0; i < list.size(); i++)
            {
                Map map = list.get(i);
                
                int menuid = Integer.parseInt(map.get("menu_id").toString());
                if (menuid == 13)
                {
                    finMafrk = true;
                    break;
                }
            }
            
            for (int i = 0; i < list.size(); i++)
            {
                Map map = list.get(i);
                
                int menuid = Integer.parseInt(map.get("menu_id").toString());
                if (menuid == 20)
                {
                    reportMark = true;
                    break;
                }
            }
            
        }
        
        if (reportMark)
        {
            
            // 薪资发放的报表
            List<Map> salarylist = reportservice.salaryMonthReport();
            model.addAttribute("salarylist", salarylist);
            
            // 按月份统计报销信息
            List<Map> expenselist = reportservice.expenseMonthReport();
            model.addAttribute("expenselist", expenselist);
        }
        if (mmark)
        {
            // 经理审核
            ExpenseAccount ea = new ExpenseAccount();
            ea.setExpenseState(Constant.EXPPENSE_STATE_ONE);
            ea.setStart(-1);
            model.addAttribute("managerlist", expservice.list(ea));
        }
        
        if (finMafrk)
        {
            // 财务审核
            ExpenseAccount ea = new ExpenseAccount();
            ea.setExpenseState(Constant.EXPPENSE_STATE_TWO);
            ea.setStart(-1);
            model.addAttribute("financelist", expservice.list(ea));
        }
        
        return "main/bootm";
    }
    
    /**
     * 退出登陆
     * 
     * @return
     */
    @RequestMapping("exit.do")
    public String exit(HttpSession session)
    {
        
        session.removeAttribute("user");
        
        return "redirect:login.jsp";
    }
    
    /**
     * 加载当前登录用户的个人信息
     * 
     * @return
     */
    @RequestMapping("user.do")
    public String loaduser()
    {
        
        return "main/user_info";
    }
    
}
