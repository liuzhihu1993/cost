package com.fh.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fh.bean.UserInfo;

/**
 * 过滤器,防止非法登陆
 * 
 * @author 风华项目组出品
 * 
 */
public class LoginFilter implements Filter
{
    
    /**
     * Default constructor.
     */
    public LoginFilter()
    {
        
    }
    
    public void destroy()
    {
        
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
        throws IOException, ServletException
    {
        
        // response
        HttpServletResponse response = (HttpServletResponse)resp;
        
        // request
        HttpServletRequest request = (HttpServletRequest)req;
        // 获取session
        HttpSession session = request.getSession();
        
        // 获取当前登陆用户信息
        UserInfo user = (UserInfo)session.getAttribute("user");
        
        String loginjsp = request.getContextPath() + "/login_info.jsp";
        
        StringBuffer url = request.getRequestURL();
        System.out.println(url.toString());
        
        if (user != null)
        {
            chain.doFilter(request, response);
        }
        else if (url.toString().contains("/login.jsp"))
        {
            chain.doFilter(request, response);
        }
        else if (url.toString().contains("/login_info.jsp"))
        {
            chain.doFilter(request, response);
        }
        else if (url.toString().contains("/res/"))
        {
            chain.doFilter(request, response);
        }
        else if (url.toString().contains("login.do"))
        {
            chain.doFilter(request, response);
        }
        else
        {
            response.sendRedirect(loginjsp);
        }
        
    }
    
    public void init(FilterConfig fConfig)
        throws ServletException
    {
        
    }
    
}
