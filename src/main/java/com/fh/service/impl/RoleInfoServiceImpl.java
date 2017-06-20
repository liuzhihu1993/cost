package com.fh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.bean.RoleInfo;
import com.fh.dao.RoleInfoDao;
import com.fh.service.RoleInfoService;
import com.fh.util.Constant;

/**
 * 角色管理业务层接口实现类
 * 
 * @author 风华项目组出品
 * 
 */
@Service
@Transactional
public class RoleInfoServiceImpl implements RoleInfoService
{
    @Autowired
    private RoleInfoDao roledao;

    public void add(RoleInfo info) {
        roledao.add(info);

    }

    public List<RoleInfo> list(RoleInfo info) {
        condition(info);
        // TODO Auto-generated method stub
        return roledao.list(info);
    }

    public long getcount(RoleInfo info) {
        condition(info);
        return roledao.getcount(info);
    }
    
    /**
     * 查询条件
     * @param info
     */
    public void condition(RoleInfo info){
        if (info != null) {
            info.setRoleMark(Constant.ROLE_MARK_YES);
            if (info.getRoleName() != null && !info.getRoleName().equals("")) {
                info.setRoleName("%"+info.getRoleName()+"%");   
            }

        }
    }

    public RoleInfo getInfo(RoleInfo info) {
        // TODO Auto-generated method stub
        return roledao.getInfo(info);
    }

    public void update(RoleInfo info) {
        roledao.update(info);
        
    }

    public void delete(Integer[] roleId) {
        for(Integer id:roleId){
            RoleInfo info = new RoleInfo();
            info.setRoleId(id);
            //修改无效标示
            info.setRoleMark(Constant.ROLE_MARK_NO);
            
            //其实删除做的是修改
            roledao.update(info);
        }
        
    }

}
