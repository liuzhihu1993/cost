package com.fh.dao;

import java.util.List;

import com.fh.bean.RoleInfo;

/**
 * 角色管理对应的dao层接口
 * 
 * @author 风华项目组出品
 * 
 */
public interface RoleInfoDao
{
    /**
     * 添加角色
     * @param info
     * @return
     */
    public int add(RoleInfo info);
    
    /**
     * 修改角色
     * @param info
     * @return
     */
    public int update(RoleInfo info);
    
    /**
     * 根据条件查询角色信息
     * @param info 查询条件
     * @return
     */
    public List<RoleInfo> list(RoleInfo info);
    
    /**
     * 获取总记录数
     * @param info
     * @return
     */
    public long getcount(RoleInfo info);
    
    /**
     * 根据条件查询角色信息
     * @param info 查询条件
     * @return
     */
    public RoleInfo getInfo(RoleInfo info);
}
