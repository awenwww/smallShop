package com.qfedu.controller;

import com.qfedu.service.CateService;
import com.qfedu.service.impl.CateserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminCategory_update.action")
public class adminCategory_updateaction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cid = request.getParameter("CID");
        String cname = request.getParameter("cname");
        System.out.println("------------------------");
        System.out.println(cname);
        System.out.println(cid);
        CateService cateservice = new CateserviceImpl();
        int i = cateservice.updateById(cid, cname);
       // response.sendRedirect(request.getContextPath() +"/CategoryServlet?pageNo=1");
    }
}
