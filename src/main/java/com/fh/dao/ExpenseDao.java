package com.fh.dao;

import java.util.List;
import java.util.Map;

import com.fh.bean.AuditHistory;
import com.fh.bean.ExpenseAccount;
import com.fh.bean.ExpenseDetails;

/**
 * 报销管理的数据访问dao层
 * 
 * @author 风华项目组出品
 * 
 */
public interface ExpenseDao
{
    /**
     * 添加报销单
     * 
     * @param ea 报销单
     * @return 返回影响的行数
     */
    public int addExpense(ExpenseAccount ea);
    
    /**
     * 添加报销明细
     * 
     * @param ed 报销明细
     * @return 返回影响的行数
     */
    public int addExpenseDetails(ExpenseDetails ed);
    
    /**
     * 根据条件查询报销单信息
     * 
     * @param ea 查询条件
     * @return
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
     * 添加审核历史记录
     * 
     * @param ah 历史记录信息
     * @return
     */
    public int addAuditHistory(AuditHistory ah);
    
    /**
     * 修改报销单
     * 
     * @param ea
     * @return
     */
    public int updateExpenseAccount(ExpenseAccount ea);
    
    /**
     * 根据报销单查询审核历史记录信息
     * 
     * @param ah
     * @return
     */
    public List<Map> getAuditHistoryList(ExpenseAccount ea);
    
    /**
     * 根据编号删除报销单明细
     * 
     * @param expenseId
     * @return
     */
    public int deleteExpenseDetails(Integer expenseId);
    
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
