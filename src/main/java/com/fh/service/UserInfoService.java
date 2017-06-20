package com.fh.service;

import java.util.List;

import com.fh.bean.UserInfo;

/**
 * 用户管理的业务逻辑接口
 * 
 * @author 风华项目组出品
 * 
 */
public interface UserInfoService
{
    /**
     * 添加用户信息
     * 
     * @param user
     */
    public void add(UserInfo user);
    
    /**
     * 根据条件查询用户信息
     * 
     * @param user 查询条件
     * @return
     */
    public UserInfo getUser(UserInfo user);
    
    /**
     * 根据条件查询用户角色信息
     * 
     * @param info 查询条件
     * @return
     */
    public List<UserInfo> list(UserInfo info);
    
    /**
     * 获取总记录数
     * 
     * @param info
     * @return
     */
    public long getcount(UserInfo info);
    
    /**
     * 修改用户信息
     * 
     * @param user
     */
    public void update(UserInfo user);
    
    /**
     * 根据编号删除用户信息
     * 
     * @param userId 用户编号
     */
    public void delete(Integer[] userId);
    
    /**
     * 根据账号和密码查询用户信息
     * 
     * @param user
     * @return
     */
    public UserInfo isLogin(UserInfo user);
    
}
