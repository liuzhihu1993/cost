package com.fh.dao;

import java.util.List;

import com.fh.bean.MenuInfo;

/**
 * 菜单管理的数据访问dao层
 * 
 * @author 风华项目组出品
 * 
 */
public interface MenuInfoDao
{
    /**
     * 查询菜单信息
     * 
     * @param menu
     * @return
     */
    public List<MenuInfo> list(MenuInfo menu);
    
    /**
     * 根据条件查询菜单信息
     * 
     * @param info
     * @return
     */
    public MenuInfo getInfo(MenuInfo info);
    
    /**
     * 添加菜单信息
     * 
     * @param info 菜单信息
     * @return
     */
    public int add(MenuInfo info);
    
    /**
     * 修改菜单信息
     * 
     * @param info
     * @return
     */
    public int update(MenuInfo info);
    
    /**
     * 根据编号删除菜单信息
     * 
     * @param info
     * @return
     */
    public int delete(MenuInfo info);
    
    /**
     * 根据菜单父级编号查询菜单信息
     * 
     * @param prentMenuId
     * @return
     */
    public List<MenuInfo> getMenuList(Integer prentMenuId);
}
