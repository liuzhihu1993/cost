package com.fh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.bean.AuditHistory;
import com.fh.bean.CostInfo;
import com.fh.bean.ExpenseAccount;
import com.fh.bean.UserInfo;
import com.fh.service.CostInfoService;
import com.fh.service.ExpenseService;
import com.fh.util.Constant;
import com.fh.util.Page;

/**
 * 报销相关控制器
 * 
 * @author 风华项目组出品
 * 
 */
@Controller
public class ExpenseController extends Page
{
    
    /**
     * 费用管理的业务逻辑接口
     */
    @Autowired
    private CostInfoService costservice;
    
    /**
     * 报销管理的业务逻辑接口
     */
    @Autowired
    private ExpenseService expservice;
    
    /**
     * 加载报销单
     * 
     * @return
     */
    @RequestMapping("/expense/loadadd.do")
    public String loadadd(Model model)
    {
        
        // 费用信息
        CostInfo info = new CostInfo();
        info.setCostMark(Constant.ROLE_MARK_YES);
        info.setStart(-1);
        
        // 查询所有的费用信息
        List<CostInfo> list = costservice.list(info);
        model.addAttribute("list", list);
        
        return "expense/expense_add";
    }
    
    /**
     * 填写报销单
     * 
     * @return
     */
    @RequestMapping("/expense/add.do")
    public String add(HttpSession session, ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount,
        Model model)
    {
        
        // 获取当前登陆用户信息
        UserInfo user = (UserInfo)session.getAttribute("user");
        
        if (ea != null)
        {
            ea.setUserId(user.getUserId());
            // 经理审核
            ea.setExpenseState(Constant.EXPPENSE_STATE_ONE);
        }
        
        try
        {
            expservice.add(ea, costId, expenseDetailsSmount);
            model.addAttribute("errorinfo", "报销单提交成功，请等待审核");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("errorinfo", "报销单提交失败");
        }
        
        return loadadd(model);
    }
    
    /**
     * 加载部门经理审核页面
     * 
     * @return
     */
    @RequestMapping("/expense/loadAuditManager.do")
    public String loadAuditManager(ExpenseAccount ea, Model model, HttpServletRequest request)
    {
        
        if (ea == null)
        {
            ea = new ExpenseAccount();
        }
        ea.setExpenseState(Constant.EXPPENSE_STATE_ONE);
        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(Constant.PAGE_NUM_BIG);
        model.addAttribute("list", expservice.list(ea));
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));
        
        return "expense/expense_audit_manager";
    }
    
    /**
     * 加载具体审核页面
     * 
     * @return
     */
    @RequestMapping("/expense/loadManager.do")
    public String loadManager(ExpenseAccount ea, Model model)
    {
        
        // 报销单信息
        ExpenseAccount exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        
        return "expense/expense_manager";
    }
    
    /**
     * 经理审核
     * 
     * @param ah 审核系你想
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/expense/auditManager.do")
    public String auditManager(AuditHistory ah, Model model, HttpServletRequest request, HttpSession session)
    {
        // 获取当前登陆用户信息
        UserInfo user = (UserInfo)session.getAttribute("user");
        
        if (ah != null)
        {
            ah.setUserId(user.getUserId());
        }
        
        try
        {
            expservice.auditManager(ah);
            model.addAttribute("errorinfo", "报销单审核成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("errorinfo", "报销单审核失败");
        }
        
        return loadAuditManager(null, model, request);
    }
    
    /**
     * 加载部门财务审核页面
     * 
     * @return
     */
    @RequestMapping("/expense/loadAuditFinance.do")
    public String loadAuditFinance(ExpenseAccount ea, Model model, HttpServletRequest request)
    {
        
        if (ea == null)
        {
            ea = new ExpenseAccount();
        }
        ea.setExpenseState(Constant.EXPPENSE_STATE_TWO);
        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(Constant.PAGE_NUM_BIG);
        model.addAttribute("list", expservice.list(ea));
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));
        
        return "expense/expense_audit_finance";
    }
    
    /**
     * 加载具体财务审核页面
     * 
     * @return
     */
    @RequestMapping("/expense/loadFinance.do")
    public String loadFinance(ExpenseAccount ea, Model model)
    {
        
        // 报销单信息
        ExpenseAccount exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        // 审核历史记录信息
        List<Map> historyList = expservice.getAuditHistoryList(ea);
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        model.addAttribute("historyList", historyList);
        
        return "expense/expense_finance";
    }
    
    /**
     * 财务审核
     * 
     * @param ah
     * @param model
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/expense/auditFinance.do")
    public String auditFinance(AuditHistory ah, Model model, HttpServletRequest request, HttpSession session)
    {
        
        // 获取当前登陆用户信息
        UserInfo user = (UserInfo)session.getAttribute("user");
        
        if (ah != null)
        {
            ah.setUserId(user.getUserId());
        }
        
        try
        {
            expservice.auditFinance(ah);
            model.addAttribute("errorinfo", "报销单审核成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("errorinfo", "报销单审核失败");
        }
        
        return loadAuditFinance(null, model, request);
    }
    
    /**
     * 查看我的报销单
     * 
     * @return
     */
    @RequestMapping("/expense/mylist.do")
    public String mylist(ExpenseAccount ea, Model model, HttpServletRequest request, HttpSession session)
    {
        
        if (ea == null)
        {
            ea = new ExpenseAccount();
        }
        UserInfo user = (UserInfo)session.getAttribute("user");
        ea.setUserId(user.getUserId());
        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(Constant.PAGE_NUM_BIG);
        model.addAttribute("list", expservice.list(ea));
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));
        
        return "expense/expense_mylist";
    }
    
    /**
     * 查看报销单明细
     * 
     * @return
     */
    @RequestMapping("/expense/myshow.do")
    public String myshow(ExpenseAccount ea, Model model)
    {
        
        // 报销单信息
        ExpenseAccount exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        // 审核历史记录信息
        List<Map> historyList = expservice.getAuditHistoryList(ea);
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        model.addAttribute("historyList", historyList);
        return "expense/expense_myshow";
    }
    
    /**
     * 加载报销单修改页面
     * 
     * @return
     */
    @RequestMapping("/expense/loadupdate.do")
    public String loadupdate(ExpenseAccount ea, Model model)
    {
        // 报销单信息
        ExpenseAccount exp = expservice.getExpenseAccount(ea);
        model.addAttribute("exp", exp);
        
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        model.addAttribute("list", list);
        
        // 费用信息
        CostInfo info = new CostInfo();
        info.setCostMark(Constant.ROLE_MARK_YES);
        info.setStart(-1);
        
        // 查询所有的费用信息
        List<CostInfo> costlist = costservice.list(info);
        model.addAttribute("costlist", costlist);
        
        return "expense/expense_update";
    }
    
    /**
     * 重新提交报销单
     * 
     * @param request
     * @param session
     * @param ea
     * @param costId
     * @param expenseDetailsSmount
     * @param model
     * @return
     */
    @RequestMapping("/expense/update.do")
    public String update(HttpServletRequest request, HttpSession session, ExpenseAccount ea, Integer[] costId,
        Double[] expenseDetailsSmount, Model model)
    {
        
        // 获取当前登陆用户信息
        UserInfo user = (UserInfo)session.getAttribute("user");
        
        if (ea != null)
        {
            ea.setUserId(user.getUserId());
            // 经理审核
            ea.setExpenseState(Constant.EXPPENSE_STATE_ONE);
        }
        
        try
        {
            expservice.update(ea, costId, expenseDetailsSmount);
            model.addAttribute("errorinfo", "报销单重新提交成功，请等待审核");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("errorinfo", "报销单提交失败");
        }
        
        return mylist(null, model, request, session);
    }
    
    /**
     * 报销查询
     * 
     * @return
     */
    @RequestMapping("/expense/list.do")
    public String list(ExpenseAccount ea, Model model, HttpServletRequest request)
    {
        
        if (ea == null)
        {
            ea = new ExpenseAccount();
        }
        
        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(Constant.PAGE_NUM_BIG);
        model.addAttribute("list", expservice.list(ea));
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));
        
        return "expense/expense_list";
    }
    
    /**
     * 查看报销单明细
     * 
     * @return
     */
    @RequestMapping("/expense/show.do")
    public String show(ExpenseAccount ea, Model model)
    {
        
        // 报销单信息
        ExpenseAccount exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        // 审核历史记录信息
        List<Map> historyList = expservice.getAuditHistoryList(ea);
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        model.addAttribute("historyList", historyList);
        
        return "expense/expense_show";
    }
    
    /**
     * 我的审核
     * 
     * @return
     */
    @RequestMapping("/expense/myauditlist.do")
    public String myauditlist(HttpServletRequest request, ExpenseAccount ea, HttpSession session, Model model)
    {
        
        if (ea == null)
        {
            ea = new ExpenseAccount();
        }
        
        // 分页信息
        this.initPage(request);
        // 起始记录
        ea.setStart(this.getPageNo());
        // 每页显示记录数
        ea.setLength(Constant.PAGE_NUM_BIG);
        
        // 获取当前用户登录信息
        UserInfo user = (UserInfo)session.getAttribute("user");
        
        ea.setUserId(user.getUserId());
        List<ExpenseAccount> list = expservice.getLit(ea);
        model.addAttribute("list", list);
        // 总记录数
        model.addAttribute("total", expservice.getcount(ea));
        
        return "expense/expense_myauditlist";
    }
    
    /**
     * 查看报销单明细
     * 
     * @return
     */
    @RequestMapping("/expense/myauditshow.do")
    public String myauditshow(ExpenseAccount ea, Model model)
    {
        // 报销单信息
        ExpenseAccount exp = expservice.getExpenseAccount(ea);
        // 报销明细
        List<Map> list = expservice.getExpenseDetailsList(ea);
        // 审核历史记录信息
        List<Map> historyList = expservice.getAuditHistoryList(ea);
        model.addAttribute("exp", exp);
        model.addAttribute("list", list);
        model.addAttribute("historyList", historyList);
        return "expense/expense_myauditshow";
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
