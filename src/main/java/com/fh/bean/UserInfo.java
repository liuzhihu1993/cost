package com.fh.bean;

import com.fh.util.BaseBean;

/**
 * 用户信息的实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class UserInfo extends BaseBean
{
    
    private Integer userId;// 用户编号
    
    private Integer roleId;// 角色编号
    
    private String userName;// 用户姓名
    
    private String userSex;// 用户性别
    
    private int userAge;// 用户年龄
    
    private String userAccount;// 账号
    
    private String userPassword;// 密码
    
    private Double userSalary; // 薪资
    
    private String userMark; // 标示
    
    private String roleName;// 角色名称
    
    public String getRoleName()
    {
        return roleName;
    }
    
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public Integer getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getUserSex()
    {
        return userSex;
    }
    
    public void setUserSex(String userSex)
    {
        this.userSex = userSex;
    }
    
    public int getUserAge()
    {
        return userAge;
    }
    
    public void setUserAge(int userAge)
    {
        this.userAge = userAge;
    }
    
    public String getUserAccount()
    {
        return userAccount;
    }
    
    public void setUserAccount(String userAccount)
    {
        this.userAccount = userAccount;
    }
    
    public String getUserPassword()
    {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
    
    public Double getUserSalary()
    {
        return userSalary;
    }
    
    public void setUserSalary(Double userSalary)
    {
        this.userSalary = userSalary;
    }
    
    public String getUserMark()
    {
        return userMark;
    }
    
    public void setUserMark(String userMark)
    {
        this.userMark = userMark;
    }
    
    @Override
    public String toString()
    {
        return "UserInfo [userId=" + userId + ", roleId=" + roleId + ", userName=" + userName + ", userSex=" + userSex
            + ", userAge=" + userAge + ", userAccount=" + userAccount + ", userPassword=" + userPassword
            + ", userSalary=" + userSalary + ", userMark=" + userMark + ", roleName=" + roleName + "]";
    }
    
}
