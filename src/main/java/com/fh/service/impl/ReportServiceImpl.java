package com.fh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.ReportDao;
import com.fh.service.ReportService;

/**
 * 报表业务逻辑实现类
 * 
 * @author 风华项目组出品
 * 
 */
@Service
@Transactional
public class ReportServiceImpl implements ReportService
{
    
    @Autowired
    private ReportDao reportDao;
    
    public List<Map> salaryMonthReport()
    {
        
        return reportDao.salaryMonthReport();
    }
    
    public List<Map> expenseMonthReport()
    {
        
        return reportDao.expenseMonthReport();
    }
    
    public List<Map> expenseCostReport()
    {
        
        return reportDao.expenseCostReport();
    }
    
}
