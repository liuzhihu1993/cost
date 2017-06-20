package com.fh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.bean.MenuInfo;
import com.fh.dao.MenuInfoDao;
import com.fh.service.MenuInfoService;

/**
 * 菜单管理的业务逻辑实现类
 * 
 * @author 风华项目组出品
 * 
 */
@Service
@Transactional
public class MenuInfoServiceImpl implements MenuInfoService
{
    
    @Autowired
    private MenuInfoDao menuInfoDao;
    
    public List<MenuInfo> list(MenuInfo info)
    {
        
        return menuInfoDao.list(info);
    }
    
    public MenuInfo getInfo(MenuInfo info)
    {
        
        return menuInfoDao.getInfo(info);
    }
    
    public void add(MenuInfo info)
    {
        menuInfoDao.add(info);
        
    }
    
    public void update(MenuInfo info)
    {
        menuInfoDao.update(info);
        
    }
    
    public void delete(MenuInfo info)
    {
        menuInfoDao.delete(info);
    }
    
    public List<MenuInfo> getMenuList(Integer prentMenuId)
    {
        
        return menuInfoDao.getMenuList(prentMenuId);
    }
    
}
