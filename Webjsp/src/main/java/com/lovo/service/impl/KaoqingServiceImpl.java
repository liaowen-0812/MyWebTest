package com.lovo.service.impl;

import com.lovo.bean.SysKaoqing;
import com.lovo.bean.SysStudent;
import com.lovo.bean.fileBean;
import com.lovo.bean.pageBean;
import com.lovo.dao.IKaoqingDao;
import com.lovo.mybatisdb.GetSession;
import com.lovo.service.IKaoqingService;
import com.lovo.util.fileUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KaoqingServiceImpl implements IKaoqingService {

    /**
     * 根据用户名查询是否有该用户
     * @param stuName 用户名
     * @return 用户
     */
    public boolean findStuBuStuName(String stuName){
        SqlSession session = GetSession.creatSession();
        IKaoqingDao dao = session.getMapper(IKaoqingDao.class);
        SysStudent stu = dao.findStuBuStuName(stuName);
        if(stu == null ){
            return  false;
        }
        return true;
    }
    public boolean insertKaoqing(SysKaoqing kq){
        SqlSession session = GetSession.creatSession();
        IKaoqingDao dao = session.getMapper(IKaoqingDao.class);
        SysStudent stu = dao.findStuBuStuName(kq.getSysStu().getSysStuName());
        kq.setSysStu(stu);
        int id = dao.insertKaoqing(kq);
        session.commit();
        session.close();
        if(id== 1){
            return true;
        }
        return false;
    }

    public Map findAllKaoqing(String name, String pageinfo, pageBean page){
        SqlSession session = GetSession.creatSession();
        IKaoqingDao dao = session.getMapper(IKaoqingDao.class);
        Map<String,String> map = new HashMap<>();
        map.put("name",name);


        page.setAllCount(dao.findAllKaoqingNum(map));

        if("上一页".equals(pageinfo)){
            if(page.getCurentPage() == 1){
                page.setCurentPage(page.getMaxPage());
            }else{
                page.setCurentPage(page.getCurentPage()-1);
            }
        }else if("下一页".equals(pageinfo)){
            if(page.getCurentPage() == page.getMaxPage()){
                page.setCurentPage(1);
            }else{
                page.setCurentPage(page.getCurentPage()+1);
            }
        }else if("查询".equals(pageinfo)){
                page.setCurentPage(1);
        }


        int start = page.getStartPage();
        map.put("startPage",start+"");
        map.put("countPage",page.getCountPage()+"");
        List<SysKaoqing> list = dao.findAllKaoqing(map);

        Map m = new HashMap();
        m.put("list",list);
        m.put("page",page);
        session.close();

        return m;
    }

    /**
     * 存储图片
     * @param fileName
     */
    public void insertFileInfo(String fileName){
        SqlSession session = GetSession.creatSession();
        IKaoqingDao dao = session.getMapper(IKaoqingDao.class);
        dao.insertFileInfo(fileName);
        session.commit();
        session.close();
    }


    /**
     * 查询所有图片名
     * @return
     */
    public List<fileBean> findAllName(){
        SqlSession session = GetSession.creatSession();
        IKaoqingDao dao = session.getMapper(IKaoqingDao.class);
        List<fileBean> list = dao.findAllName();
        session.close();
        return list;
    }


}
