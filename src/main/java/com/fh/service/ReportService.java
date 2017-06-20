package com.fh.service;

import java.util.List;
import java.util.Map;

/**
 * 报表业务逻辑接口
 * 
 * @author 风华项目组出品
 * 
 */
public interface ReportService
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
     * 根据费用名称统计报销金额
     * 
     * @return
     */
    public List<Map> expenseCostReport();
}
