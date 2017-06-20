package com.fh.bean;

/**
 * 菜单管理对应实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class MenuInfo
{
    
    private Integer menuId;//菜单编号
    
    private Integer prentMenuId;//菜单的父级id
    
    private String prentName;//父级菜单名称
  
    private String menuName;//菜单名称
    
    private String menuUrl;//菜单URL地址
    
    

    public String getPrentName() {
        return prentName;
    }

    public void setPrentName(String prentName) {
        this.prentName = prentName;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getPrentMenuId() {
        return prentMenuId;
    }

    public void setPrentMenuId(Integer prentMenuId) {
        this.prentMenuId = prentMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    
}
