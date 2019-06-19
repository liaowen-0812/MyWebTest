package com.lovo.servlet;

import com.lovo.bean.fileBean;
import com.lovo.service.IKaoqingService;
import com.lovo.service.impl.KaoqingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class imgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IKaoqingService service = new KaoqingServiceImpl();
        List<fileBean> list = service.findAllName();
        request.setAttribute("list",list);
        request.getRequestDispatcher("f/imageShow.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
