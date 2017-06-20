package com.fh.bean;

import java.util.Date;

/**
 * 审核历史记录实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class AuditHistory
{
    
    private Integer auditId;// 审核记录编号
    
    private Integer expenseId;// 报销单编号
    
    private Integer userId;// 审核人编号
    
    private Date auditTime;// 审核时间
    
    private String auditState;// 审核状态
    
    private String auditDesc;// 审核描述
    
    public Integer getAuditId()
    {
        return auditId;
    }
    
    public void setAuditId(Integer auditId)
    {
        this.auditId = auditId;
    }
    
    public Integer getExpenseId()
    {
        return expenseId;
    }
    
    public void setExpenseId(Integer expenseId)
    {
        this.expenseId = expenseId;
    }
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public Date getAuditTime()
    {
        return auditTime;
    }
    
    public void setAuditTime(Date auditTime)
    {
        this.auditTime = auditTime;
    }
    
    public String getAuditState()
    {
        return auditState;
    }
    
    public void setAuditState(String auditState)
    {
        this.auditState = auditState;
    }
    
    public String getAuditDesc()
    {
        return auditDesc;
    }
    
    public void setAuditDesc(String auditDesc)
    {
        this.auditDesc = auditDesc;
    }
    
}
