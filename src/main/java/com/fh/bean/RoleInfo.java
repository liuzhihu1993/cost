package com.fh.bean;

import com.fh.util.BaseBean;

/**
 * 角色管理对应的实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class RoleInfo extends BaseBean
{
    private Integer roleId;// 角色编号
    
    private String roleName;// 角色名称
    
    private String roleDesc;// 角色描述
    
    private String roleMark;// 角色标识
    
    public Integer getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }
    
    public String getRoleName()
    {
        return roleName;
    }
    
    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
    
    public String getRoleDesc()
    {
        return roleDesc;
    }
    
    public void setRoleDesc(String roleDesc)
    {
        this.roleDesc = roleDesc;
    }
    
    public String getRoleMark()
    {
        return roleMark;
    }
    
    public void setRoleMark(String roleMark)
    {
        this.roleMark = roleMark;
    }
    
    @Override
    public String toString()
    {
        return "RoleInfo [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", roleMark="
            + roleMark + "]";
    }
    
}
