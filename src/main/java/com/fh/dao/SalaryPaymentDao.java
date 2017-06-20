package com.fh.dao;

import java.util.List;

import com.fh.bean.SalaryPayment;

/**
 * 薪资管理的数据访问dao层
 * 
 * @author 风华项目组出品
 * 
 */
public interface SalaryPaymentDao
{
    /**
     * 添加薪资发放记录
     * 
     * @param sp 发放记录
     * @return 返回影响的行数
     */
    public int add(SalaryPayment sp);
    
    /**
     * 查询所有的薪资
     * 
     * @param sp 查询条件
     * @return
     */
    public List<SalaryPayment> list(SalaryPayment sp);
    
    /**
     * 返回总记录数
     * 
     * @param sp
     * @return
     */
    public Long getcount(SalaryPayment sp);
}
