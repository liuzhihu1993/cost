package com.fh.dao;

import java.util.List;
import java.util.Map;

/**
 * 报表管理的数据访问dao层
 * 
 * @author 风华项目组出品
 * 
 */
public interface ReportDao
{
    /**
     * 按月份统计薪资发放情况
     * 
     * @return
     */
    public List<Map> salaryMonthReport();
    
    /**
     * 按月份统计报销情况
     * 
     * @return
     */
    public List<Map> expenseMonthReport();
    
    /**
     * 根据费用类别统计报销金额
     * 
     * @return
     */
    public List<Map> expenseCostReport();
}
