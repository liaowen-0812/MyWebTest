package com.lovo.servlet;

import com.lovo.bean.SysKaoqing;
import com.lovo.bean.SysStudent;
import com.lovo.service.IKaoqingService;
import com.lovo.service.impl.KaoqingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class insertKQServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IKaoqingService service = new KaoqingServiceImpl();
        SysStudent stu = new SysStudent();
        stu.setSysStuName(request.getParameter("studentName"));
        SysKaoqing kq = new SysKaoqing();
        kq.setSysStu(stu);
        kq.setSysInsertTime(request.getParameter("insertTime"));
        kq.setSysMan(request.getParameter("userName"));
        kq.setSysTime(request.getParameter("inputTime"));
        kq.setSysType(request.getParameter("selectType"));
        boolean bool = service.insertKaoqing(kq);
        if(bool){
            request.getRequestDispatcher("/message").forward(request,response);
        }else{
            request.getRequestDispatcher("reg.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
