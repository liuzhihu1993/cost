package com.fh.dao;

import java.util.List;
import java.util.Map;

import com.fh.bean.RoleMenuInfo;

/**
 * 权限变更的数据访问dao层
 * 
 * @author 风华项目组出品
 * 
 */
public interface AnthorityDao
{
    /**
     * 添加角色权限关系信息
     * 
     * @param info
     * @return
     */
    public int add(RoleMenuInfo info);
    
    /**
     * 根据条件查询已选择的菜单
     * 
     * @param info
     * @return
     */
    public List<RoleMenuInfo> list(RoleMenuInfo info);
    
    /**
     * 根据角色编号删除信息
     * 
     * @param roleId
     * @return
     */
    public int delete(Integer roleId);
    
    /**
     * 根据角色编号查询菜单信息
     * 
     * @param roleId
     * @return
     */
    public List<Map> getMenuList(Integer roleId);
}
