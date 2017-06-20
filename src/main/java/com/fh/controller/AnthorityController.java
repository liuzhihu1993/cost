package com.fh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.bean.MenuInfo;
import com.fh.bean.RoleInfo;
import com.fh.bean.RoleMenuInfo;
import com.fh.service.AnthorityService;
import com.fh.service.MenuInfoService;
import com.fh.service.RoleInfoService;
import com.fh.util.Constant;
import com.fh.util.Page;

/**
 * 权限管理的控制器
 * 
 * @author 风华项目组出品
 * 
 */
@Controller
public class AnthorityController extends Page
{
    
    /**
     * 角色管理的业务逻辑接口
     */
    @Autowired
    private RoleInfoService roleservice;
    
    /**
     * 菜单管理的业务逻辑接口
     */
    @Autowired
    private MenuInfoService menuservice;
    
    /**
     * 权限管理的业务逻辑接口
     */
    @Autowired
    private AnthorityService anservice;
    
    /**
     * 显示权限菜单首页
     * 
     * @return
     */
    @RequestMapping("/anthority/list.do")
    public String list(RoleInfo info, Model model, HttpServletRequest request)
    {
        
        if (info == null)
        {
            info = new RoleInfo();
        }
        // 分页信息
        this.initPage(request);
        // 起始记录
        info.setStart(this.getPageNo());
        // 每页显示记录数
        info.setLength(Constant.PAGE_NUM_BIG);
        info.setRoleMark(Constant.ROLE_MARK_YES);
        model.addAttribute("list", roleservice.list(info));
        // 总记录数
        model.addAttribute("total", roleservice.getcount(info));
        
        return "anthority/anthority_list";
    }
    
    /**
     * 权限变更
     * 
     * @return
     */
    @RequestMapping("/anthority/loadchange.do")
    public String loadchange(RoleInfo info, Model model)
    {
        
        // 角色信息
        RoleInfo role = roleservice.getInfo(info);
        model.addAttribute("role", role);
        
        // 查询所有的菜单信息
        List<MenuInfo> list = menuservice.list(null);
        model.addAttribute("list", list);
        
        // 查询已有权限
        RoleMenuInfo rminfo = new RoleMenuInfo();
        rminfo.setRoleId(info.getRoleId());
        List<RoleMenuInfo> rmlist = anservice.list(rminfo);
        model.addAttribute("rmlist", rmlist);
        
        return "anthority/anthority_change";
        
    }
    
    /**
     * 权限变更
     * 
     * @return
     */
    @RequestMapping("/anthority/change.do")
    public String change(Integer roleId, Integer[] menuIds, Model model, HttpServletRequest request)
    {
        
        try
        {
            anservice.add(roleId, menuIds);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("errorinfo", "变更失败");
        }
        
        return list(null, model, request);
    }
}
