package com.fh.service;

import java.util.List;

import com.fh.bean.RoleInfo;

/**
 * 角色管理业务层接口
 * 
 * @author 风华项目组出品
 * 
 */
public interface RoleInfoService
{
    /**
     * 添加角色信息
     * @param info
     */
    public void add(RoleInfo info);
    
    /**
     * 修改角色信息
     * @param info
     */
    public void update(RoleInfo info);
    
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
     * @param info
     * @return
     */
    public RoleInfo getInfo(RoleInfo info);
    
    /**
     * 根据编号删除
     * @param roleId
     */
    public void delete(Integer[] roleId);
}
