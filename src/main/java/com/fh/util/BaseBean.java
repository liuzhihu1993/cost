package com.fh.util;

/**
 * 基础bean，所有的实体类，都需要继承这个bean
 * 
 * @author 风华项目组出品
 * 
 */
public class BaseBean
{
    
    private int start;// 起始记录
    
    private int length;// 每次查询的条数
    
    public int getStart()
    {
        return start;
    }
    
    public void setStart(int start)
    {
        this.start = start;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public void setLength(int length)
    {
        this.length = length;
    }
}
