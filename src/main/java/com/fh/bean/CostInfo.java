package com.fh.bean;

import com.fh.util.BaseBean;

/**
 * 费用管理的实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class CostInfo extends BaseBean
{
    
    private Integer costId;// 编号
    
    private String costName;// 费用名称
    
    private String costDesc;// 费用描述
    
    private String costMark;// 费用的标示
    
    public Integer getCostId()
    {
        return costId;
    }
    
    public void setCostId(Integer costId)
    {
        this.costId = costId;
    }
    
    public String getCostName()
    {
        return costName;
    }
    
    public void setCostName(String costName)
    {
        this.costName = costName;
    }
    
    public String getCostDesc()
    {
        return costDesc;
    }
    
    public void setCostDesc(String costDesc)
    {
        this.costDesc = costDesc;
    }
    
    public String getCostMark()
    {
        return costMark;
    }
    
    public void setCostMark(String costMark)
    {
        this.costMark = costMark;
    }
    
    @Override
    public String toString()
    {
        return "CostInfo [costId=" + costId + ", costName=" + costName + ", costDesc=" + costDesc + ", costMark="
            + costMark + "]";
    }
    
}
