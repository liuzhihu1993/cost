package com.fh.bean;

/**
 * 报销明细实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class ExpenseDetails
{
    
    private Integer expenseDetailsId;// 报销明细编号
    
    private Integer expenseId;// 报销单
    
    private Integer costId;// 费用
    
    private Double expenseDetailsAmount;// 报销具体金额
    
    public Integer getExpenseDetailsId()
    {
        return expenseDetailsId;
    }
    
    public void setExpenseDetailsId(Integer expenseDetailsId)
    {
        this.expenseDetailsId = expenseDetailsId;
    }
    
    public Integer getExpenseId()
    {
        return expenseId;
    }
    
    public void setExpenseId(Integer expenseId)
    {
        this.expenseId = expenseId;
    }
    
    public Integer getCostId()
    {
        return costId;
    }
    
    public void setCostId(Integer costId)
    {
        this.costId = costId;
    }
    
    public Double getExpenseDetailsAmount()
    {
        return expenseDetailsAmount;
    }
    
    public void setExpenseDetailsAmount(Double expenseDetailsAmount)
    {
        this.expenseDetailsAmount = expenseDetailsAmount;
    }
    
}
