package com.fh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.bean.CostInfo;
import com.fh.dao.CostInfoDao;
import com.fh.service.CostInfoService;
import com.fh.util.Constant;

/**
 * 费用管理的业务逻辑实现类
 * 
 * @author 风华项目组出品
 * 
 */

@Service
@Transactional
public class CostInfoServiceImpl implements CostInfoService
{
    @Autowired
    private CostInfoDao costInfoDao;
    
    public void add(CostInfo info)
    {
        costInfoDao.add(info);
        
    }
    
    @Transactional(readOnly = true)
    public List<CostInfo> list(CostInfo info)
    {
        condition(info);
        return costInfoDao.list(info);
    }
    
    @Transactional(readOnly = true)
    public long getcount(CostInfo info)
    {
        condition(info);
        return costInfoDao.getcount(info);
    }
    
    public void condition(CostInfo info)
    {
        if (info != null)
        {
            if (info.getCostName() != null && !info.getCostName().equals(""))
            {
                info.setCostName("%" + info.getCostName() + "%");
            }
        }
        
    }
    
    public CostInfo getInfo(CostInfo info)
    {
        
        return costInfoDao.getCostInfo(info);
    }
    
    public void update(CostInfo info)
    {
        costInfoDao.update(info);
        
    }
    
    public void delete(Integer[] costIds)
    {
        for (Integer costId : costIds)
        {
            CostInfo info = new CostInfo();
            info.setCostId(costId);
            info.setCostMark(Constant.ROLE_MARK_NO);
            costInfoDao.update(info);
        }
        
    }
    
}
