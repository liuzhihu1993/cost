package com.fh.util;

/**
 * 项目中常量定义的类
 * 
 * @author 风华项目组出品
 * 
 */
public class Constant
{
    // 角色标识为可用
    public final static String ROLE_MARK_YES = "1";
    
    // 角色标识为不可用
    public final static String ROLE_MARK_NO = "0";
    
    // 每页显示数字
    public final static int PAGE_NUM_BIG = 10;
    
    // 报销但作废
    public final static String EXPPENSE_STATE_DELETE = "del";
    
    // 报销单初始状态
    public final static String EXPPENSE_STATE_ZERO = "0";
    
    // 部门经理审核
    public final static String EXPPENSE_STATE_ONE = "1";
    
    // 部门经理审核不通过
    public final static String EXPPENSE_STATE_REONE = "-1";
    
    // 部门经理审核通过,财务经理审核
    public final static String EXPPENSE_STATE_TWO = "2";
    
    // 财务经理审核不通过
    public final static String EXPPENSE_STATE_RETWO = "-2";
    
    // 财务经理审核通过
    public final static String EXPPENSE_STATE_OK = "3";
}
