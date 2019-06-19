package com.lovo.servlet;

import com.lovo.bean.SysKaoqing;
import com.lovo.bean.pageBean;
import com.lovo.service.IKaoqingService;
import com.lovo.service.impl.KaoqingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class messageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        pageBean page = new pageBean();
        String username = request.getParameter("username");
        String pageinfo = request.getParameter("clickPage");

        String showPage = request.getParameter("showPage");
        if(showPage==null||"".equals(showPage)){
            showPage="1";
        }
        page.setCurentPage(Integer.parseInt(showPage));
        IKaoqingService service = new KaoqingServiceImpl();
        Map map = service.findAllKaoqing(username,pageinfo,page);
        pageBean pa = (pageBean)map.get("page");
        System.out.println(pa.getCurentPage());
        request.setAttribute("kaoqinObj",map);
        request.setAttribute("username",username);
        request.getRequestDispatcher("kaoqin/main.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
