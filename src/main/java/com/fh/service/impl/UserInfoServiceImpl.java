package com.fh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.bean.UserInfo;
import com.fh.dao.UserInfoDao;
import com.fh.service.UserInfoService;
import com.fh.util.Constant;

/**
 * 用户管理的业务逻辑实体类
 * 
 * @author 风华项目组出品
 * 
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService
{
    
    @Autowired
    private UserInfoDao userInfoDao;
    
    public void add(UserInfo user)
    {
        userInfoDao.add(user);
        
    }
    
    public UserInfo getUser(UserInfo user)
    {
        
        return userInfoDao.getUser(user);
    }
    
    public List<UserInfo> list(UserInfo info)
    {
        condition(info);
        return userInfoDao.list(info);
    }
    
    public long getcount(UserInfo info)
    {
        condition(info);
        return userInfoDao.getcount(info);
    }
    
    /**
     * 查询条件
     * 
     * @param user
     */
    public void condition(UserInfo user)
    {
        if (user != null)
        {
            if (user.getUserName() != null && !user.getUserName().equals(""))
            {
                user.setUserName("%" + user.getUserName() + "%");
            }
            
        }
    }
    
    public void update(UserInfo user)
    {
        userInfoDao.update(user);
        
    }
    
    public void delete(Integer[] userId)
    {
        
        for (Integer id : userId)
        {
            UserInfo info = new UserInfo();
            info.setUserId(id);
            info.setUserMark(Constant.ROLE_MARK_NO);
            
            userInfoDao.update(info);
            
        }
        
    }
    
    public UserInfo isLogin(UserInfo user)
    {
        return userInfoDao.login(user);
    }
    
}
