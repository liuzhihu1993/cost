package com.fh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.bean.AuditHistory;
import com.fh.bean.ExpenseAccount;
import com.fh.bean.ExpenseDetails;
import com.fh.dao.ExpenseDao;
import com.fh.service.ExpenseService;
import com.fh.util.Constant;

/**
 * 报销管理的业务逻辑实现类
 * 
 * @author 风华项目组出品
 * 
 */
@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService
{
    
    /**
     * 报销管理的数据访问接口
     */
    @Autowired
    private ExpenseDao expenseDao;
    
    public void add(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount)
    {
        
        // 添加报销单
        expenseDao.addExpense(ea);
        
        for (int i = 0; i < costId.length; i++)
        {
            ExpenseDetails ed = new ExpenseDetails();
            // 获取报销单的编号
            ed.setExpenseId(ea.getExpenseId());
            ed.setCostId(costId[i]);
            ed.setExpenseDetailsAmount(expenseDetailsSmount[i]);
            
            expenseDao.addExpenseDetails(ed);
        }
        
    }
    
    public void update(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount)
    {
        
        // 添加报销单
        expenseDao.updateExpenseAccount(ea);
        
        // 先删除以前明细，在重新添加新的明细
        expenseDao.deleteExpenseDetails(ea.getExpenseId());
        
        for (int i = 0; i < costId.length; i++)
        {
            ExpenseDetails ed = new ExpenseDetails();
            // 获取报销单的编号
            ed.setExpenseId(ea.getExpenseId());
            ed.setCostId(costId[i]);
            ed.setExpenseDetailsAmount(expenseDetailsSmount[i]);
            
            expenseDao.addExpenseDetails(ed);
        }
        
    }
    
    public List<ExpenseAccount> list(ExpenseAccount ea)
    {
        condition(ea);
        return expenseDao.list(ea);
    }
    
    public long getcount(ExpenseAccount ea)
    {
        condition(ea);
        return expenseDao.getcount(ea);
    }
    
    /**
     * 查询条件
     * 
     * @param ea
     */
    public void condition(ExpenseAccount ea)
    {
        
        if (ea != null)
        {
            if (ea.getUserName() != null && !ea.getUserName().equals(""))
            {
                
                ea.setUserName("%" + ea.getUserName() + "%");
            }
            
        }
        
    }
    
    public ExpenseAccount getExpenseAccount(ExpenseAccount ea)
    {
        
        return expenseDao.getExpenseAccount(ea);
    }
    
    public List<Map> getExpenseDetailsList(ExpenseAccount ea)
    {
        
        return expenseDao.getExpenseDetailsList(ea);
    }
    
    public void auditManager(AuditHistory ah)
    {
        
        // 订单对象
        ExpenseAccount ea = new ExpenseAccount();
        ea.setExpenseId(ah.getExpenseId());
        
        // 经理审核不通过
        if (Constant.EXPPENSE_STATE_REONE.equals(ah.getAuditState()))
        {
            ea.setExpenseState(Constant.EXPPENSE_STATE_ZERO);
            // 作废
        }
        else if (Constant.EXPPENSE_STATE_DELETE.equals(ah.getAuditState()))
        {
            ea.setExpenseState(Constant.EXPPENSE_STATE_DELETE);
        }
        else
        {
            // 审核通过
            ea.setExpenseState(ah.getAuditState());
        }
        // 修改报销单
        expenseDao.updateExpenseAccount(ea);
        // 添加历史记录
        expenseDao.addAuditHistory(ah);
    }
    
    public List<Map> getAuditHistoryList(ExpenseAccount ea)
    {
        
        return expenseDao.getAuditHistoryList(ea);
    }
    
    public void auditFinance(AuditHistory ah)
    {
        
        // 订单对象
        ExpenseAccount ea = new ExpenseAccount();
        ea.setExpenseId(ah.getExpenseId());
        
        // 财务审核不通过
        if (Constant.EXPPENSE_STATE_RETWO.equals(ah.getAuditState()))
        {
            ea.setExpenseState(Constant.EXPPENSE_STATE_ZERO);
            // 作废
        }
        else if (Constant.EXPPENSE_STATE_DELETE.equals(ah.getAuditState()))
        {
            ea.setExpenseState(Constant.EXPPENSE_STATE_DELETE);
        }
        else
        {
            // 审核通过
            ea.setExpenseState(ah.getAuditState());
        }
        // 修改报销单
        expenseDao.updateExpenseAccount(ea);
        // 添加历史记录
        expenseDao.addAuditHistory(ah);
    }
    
    public List<ExpenseAccount> getLit(ExpenseAccount ea)
    {
        
        if (ea != null)
        {
            if (ea.getUserName() != null && !ea.getUserName().equals(""))
            {
                ea.setUserName("%" + ea.getUserName() + "%");
            }
            
        }
        
        return expenseDao.getLit(ea);
    }
    
    public Long getCountLong(ExpenseAccount ea)
    {
        if (ea != null)
        {
            if (ea.getUserName() != null && !ea.getUserName().equals(""))
            {
                ea.setUserName("%" + ea.getUserName() + "%");
            }
            
        }
        return expenseDao.getCountLong(ea);
    }
    
}
