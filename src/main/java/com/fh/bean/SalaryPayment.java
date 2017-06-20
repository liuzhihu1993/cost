package com.fh.bean;

import com.fh.util.BaseBean;
import java.util.Date;

/**
 * 薪资发放的实体类
 * 
 * @author 风华项目组出品
 * 
 */
public class SalaryPayment extends BaseBean
{
    
    private Integer paymentId; // 编号
    
    private Integer userId;// 领取薪资的用户
    
    private String userName;// 领取人姓名
    
    private Date paymentTime;// 发放时间
    
    private Double paymentMoney;// 发放的金额
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public Integer getPaymentId()
    {
        return paymentId;
    }
    
    public void setPaymentId(Integer paymentId)
    {
        this.paymentId = paymentId;
    }
    
    public Integer getUserId()
    {
        return userId;
    }
    
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }
    
    public Date getPaymentTime()
    {
        return paymentTime;
    }
    
    public void setPaymentTime(Date paymentTime)
    {
        this.paymentTime = paymentTime;
    }
    
    public Double getPaymentMoney()
    {
        return paymentMoney;
    }
    
    public void setPaymentMoney(Double paymentMoney)
    {
        this.paymentMoney = paymentMoney;
    }
    
    @Override
    public String toString()
    {
        return "SalaryPayment [paymentId=" + paymentId + ", userId=" + userId + ", userName=" + userName
            + ", paymentTime=" + paymentTime + ", paymentMoney=" + paymentMoney + "]";
    }
    
}
