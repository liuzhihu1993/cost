package com.fh.service;

import java.io.InputStream;
import java.util.List;

import com.fh.bean.SalaryPayment;

/**
 * 薪资发放的业务逻辑接口
 * 
 * @author 风华项目组出品
 * 
 */
public interface SalaryPaymentService
{
    /**
     * 添加薪资发放信息
     * 
     * @param sp 薪资方法
     */
    public void add(SalaryPayment sp);
    
    /**
     * 导入数据
     * 
     * @param is
     */
    public void addAll(InputStream is)
        throws Exception;
    
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
