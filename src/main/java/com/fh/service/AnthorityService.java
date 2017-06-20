package com.fh.service;

import java.util.List;
import java.util.Map;

import com.fh.bean.RoleMenuInfo;

/**
 * 权限管理的业务逻辑接口
 * 
 * @author 风华项目组出品
 * 
 */
public interface AnthorityService
{
    /**
     * 添加
     * 
     * @param roleId
     * @param menuIds
     */
    public void add(Integer roleId, Integer[] menuIds);
    
    /**
     * 根据角色编号查询已经选择的菜单编号
     * 
     * @param info
     * @return
     */
    public List<RoleMenuInfo> list(RoleMenuInfo info);
    
    /**
     * 根据角色编号查询菜单信息
     * 
     * @param roleId
     * @return
     */
    public List<Map> getMenuList(Integer roleId);
}
