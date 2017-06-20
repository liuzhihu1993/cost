package com.fh.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具类
 * 
 * @author 风华项目组出品
 * 
 */
public class Page
{
    
    private int pageNo = 0;// 起始记录数
    
    /**
     * 初始化分页信息
     */
    public void initPage(HttpServletRequest request)
    {
        String page_str = request.getParameter("pager.offset");
        if (page_str != null && !page_str.equals(""))
        {
            pageNo = Integer.parseInt(page_str);
        }
    }
    
    public int getPageNo()
    {
        return pageNo;
    }
}
