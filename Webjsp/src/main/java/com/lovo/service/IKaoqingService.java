package com.lovo.service;


import com.lovo.bean.SysKaoqing;
import com.lovo.bean.fileBean;
import com.lovo.bean.pageBean;

import java.util.List;
import java.util.Map;

public interface IKaoqingService {

    /**
     * 根据用户名查询是否有该用户
     * @param stuName 用户名
     * @return 用户
     */
    public boolean findStuBuStuName(String stuName);



    /**
     * 添加考勤记录
     * @param kq 考勤对象
     * @return 是否成功
     * 首先根据用户名查询用户id
     */
    public boolean insertKaoqing(SysKaoqing kq);

    /**
     * 按照条件查询所有记录和学生姓名
     * @param name 姓名
     * @return 记录对象
     */
    public Map findAllKaoqing(String name, String pageinfo, pageBean page);

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
