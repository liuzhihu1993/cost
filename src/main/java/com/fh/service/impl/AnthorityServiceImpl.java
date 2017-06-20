package com.fh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.bean.RoleMenuInfo;
import com.fh.dao.AnthorityDao;
import com.fh.service.AnthorityService;

/**
 * 权限管理的业务逻辑实现类
 * 
 * @author 风华项目组出品
 * 
 */
@Service
@Transactional
public class AnthorityServiceImpl implements AnthorityService
{
    
    @Autowired
    private AnthorityDao anthorityDao;
    
    public void add(Integer roleId, Integer[] menuIds)
    {
        // 先删除
        anthorityDao.delete(roleId);
        
        // 后添加
        for (Integer menuId : menuIds)
        {
            RoleMenuInfo info = new RoleMenuInfo();
            info.setRoleId(roleId);
            info.setMenuId(menuId);
            anthorityDao.add(info);
            
        }
        
    }
    
    public List<RoleMenuInfo> list(RoleMenuInfo info)
    {
        
        return anthorityDao.list(info);
    }
    
    public List<Map> getMenuList(Integer roleId)
    {
        
        return anthorityDao.getMenuList(roleId);
    }
    
}
