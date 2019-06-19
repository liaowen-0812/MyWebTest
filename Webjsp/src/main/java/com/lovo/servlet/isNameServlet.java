package com.lovo.servlet;

import com.lovo.service.IKaoqingService;
import com.lovo.service.impl.KaoqingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class isNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IKaoqingService service = new KaoqingServiceImpl();
        boolean flag = service.findStuBuStuName(request.getParameter("name"));
        PrintWriter pw = response.getWriter();
        pw.write(flag+"");

        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
