package com.fh.bean;

/**
 * 角色菜单关系实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class RoleMenuInfo
{
    
    private Integer roleMenuId;// 关系编号
    
    /**
     * 菜单编号
     */
    private Integer menuId;
    
    private Integer roleId;// 角色编号
    
    public Integer getRoleMenuId()
    {
        return roleMenuId;
    }
    
    public void setRoleMenuId(Integer roleMenuId)
    {
        this.roleMenuId = roleMenuId;
    }
    
    public Integer getMenuId()
    {
        return menuId;
    }
    
    public void setMenuId(Integer menuId)
    {
        this.menuId = menuId;
    }
    
    public Integer getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }
    
}
