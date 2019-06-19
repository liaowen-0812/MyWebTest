package com.lovo.dao;

import com.lovo.bean.SysKaoqing;
import com.lovo.bean.SysStudent;
import com.lovo.bean.fileBean;

import java.util.List;
import java.util.Map;

public interface IKaoqingDao {

    /**
     * 根据用户名查询是否有该用户
     * @param stuName 用户名
     * @return 用户
     */
    public SysStudent findStuBuStuName(String stuName);

    /**
     * 添加考勤记录
     * @param kq 考勤对象
     * @return 影响的行数
     */
    public int insertKaoqing(SysKaoqing kq);

    /**
     * 按照条件查询所有记录和学生姓名
     * @return 记录对象
     */
    public List<SysKaoqing> findAllKaoqing(Map<String,String> map);


    /**
     * 按照条件查询所有记录和学生姓名总行数
     * @return 记录对象
     */
    public int findAllKaoqingNum(Map<String,String> map);

    /**
     * 存储图片
     * @param fileName
     */
    public void insertFileInfo(String fileName);

    /**
     * 查询所有图片名
     * @return
     */
    public List<fileBean> findAllName();
}
