package com.fh.bean;

import java.io.Serializable;
import java.util.Date;

import com.fh.util.BaseBean;

/**
 * 报销单的实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class ExpenseAccount extends BaseBean implements Serializable
{
    
    private Integer expenseId;// 报销编号
    
    private Integer userId;// 报销人
    
    private String userName;// 报销人姓名
    
    private String expenseName;// 报销原因
    
    private String expenseDesc;// 报销详情
    
    private String expenseState;// 报销状态
    
    private Double expenseTotal;// 报销总金额
    
    private Date expenseTime; // 报销时间
    
    private Integer managerMark;// 经理审核标识：1 为审核通过 0未通过
    
    private Integer managerId;// 经理审核的Id
    
    private String managerName;// 经理审核的name
    
    private String managerDesc;// 经理审核描述
    
    private Integer financeMark; // 财务审核：0 未通过 1 通过 2 作废
    
    private String financeDesc;// 财务审核描述
    
    private Integer financeId; // 财务审核人的ID
    
    private String financeName; // 财务审核任务的姓名
    
    public Integer getManagerId()
    {
        return managerId;
    }
    
    public void setManagerId(Integer managerId)
    {
        this.managerId = managerId;
    }
    
    public String getManagerName()
    {
        return managerName;
    }
    
    public void setManagerName(String managerName)
    {
        this.managerName = managerName;
    }
    
    public Integer getFinanceId()
    {
        return financeId;
    }
    
    public void setFinanceId(Integer financeId)
    {
        this.financeId = financeId;
    }
    
    public String getFinanceName()
    {
        return financeName;
    }
    
    public void setFinanceName(String financeName)
    {
        this.financeName = financeName;
    }
    
    public Integer getManagerMark()
    {
        return managerMark;
    }
    
    public void setManagerMark(Integer managerMark)
    {
        this.managerMark = managerMark;
    }
    
    public String getManagerDesc()
    {
        return managerDesc;
    }
    
    public void setManagerDesc(String managerDesc)
    {
        this.managerDesc = managerDesc;
    }
    
    public Integer getFinanceMark()
    {
        return financeMark;
    }
    
    public void setFinanceMark(Integer financeMark)
    {
        this.financeMark = financeMark;
    }
    
    public String getFinanceDesc()
    {
        return financeDesc;
    }
    
    public void setFinanceDesc(String financeDesc)
    {
        this.financeDesc = financeDesc;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public Date getExpenseTime()
    {
        return expenseTime;
    }
    
    public void setExpenseTime(Date expenseTime)
    {
        this.expenseTime = expenseTime;
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
    
    public String getExpenseName()
    {
        return expenseName;
    }
    
    public void setExpenseName(String expenseName)
    {
        this.expenseName = expenseName;
    }
    
    public String getExpenseDesc()
    {
        return expenseDesc;
    }
    
    public void setExpenseDesc(String expenseDesc)
    {
        this.expenseDesc = expenseDesc;
    }
    
    public String getExpenseState()
    {
        return expenseState;
    }
    
    public void setExpenseState(String expenseState)
    {
        this.expenseState = expenseState;
    }
    
    public Double getExpenseTotal()
    {
        return expenseTotal;
    }
    
    public void setExpenseTotal(Double expenseTotal)
    {
        this.expenseTotal = expenseTotal;
    }
    
    @Override
    public String toString()
    {
        return "ExpenseAccount [expenseId=" + expenseId + ", userId=" + userId + ", expenseName=" + expenseName
            + ", expenseDesc=" + expenseDesc + ", expenseState=" + expenseState + ", expenseTotal=" + expenseTotal
            + ", expenseTime=" + expenseTime + "]";
    }
    
}
