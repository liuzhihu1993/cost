package com.fh.service;

import java.util.List;
import java.util.Map;

import com.fh.bean.AuditHistory;
import com.fh.bean.ExpenseAccount;

/**
 * 报销管理的业务逻辑接口
 * 
 * @author 风华项目组出品
 * 
 */
public interface ExpenseService
{
    /**
     * 添加报销单
     * 
     * @param ea 报销单
     * @param costId 报销的费用
     * @param expenseDetailsSmount 报销的金额
     */
    public void add(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount);
    
    /**
     * 修改报销单
     * 
     * @param ea 报销单
     * @param costId 报销的费用
     * @param expenseDetailsSmount 报销的金额
     */
    public void update(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount);
    
    /**
     * 根据条件查询报销单信息
     * 
     * @param ea 查询条件
     * @return 返回未审核的报销单
     */
    public List<ExpenseAccount> list(ExpenseAccount ea);
    
    /**
     * 查询总记录数
     * 
     * @param ea
     * @return
     */
    public long getcount(ExpenseAccount ea);
    
    /**
     * 根据编号查询报销单
     * 
     * @param ea 查询条件
     * @return 返回单个报销单信息
     */
    public ExpenseAccount getExpenseAccount(ExpenseAccount ea);
    
    /**
     * 根据报销单编号查询报销明细
     * 
     * @param ea 查询条件
     * @return 返回报销的明细
     */
    public List<Map> getExpenseDetailsList(ExpenseAccount ea);
    
    /**
     * 经理审核
     * 
     * @param ah
     */
    public void auditManager(AuditHistory ah);
    
    /**
     * 财务审核
     * 
     * @param ah
     */
    public void auditFinance(AuditHistory ah);
    
    /**
     * 根据报销单编号查询审核历史记录信息
     * 
     * @param ah
     * @return
     */
    public List<Map> getAuditHistoryList(ExpenseAccount ea);
    
    /**
     * 根据审核人查询报销单信息
     * 
     * @param userId 用户编号
     * @return
     */
    public List<ExpenseAccount> getLit(ExpenseAccount ea);
    
    /**
     * 获取总记录数
     * 
     * @param ea
     * @return
     */
    public Long getCountLong(ExpenseAccount ea);
}
