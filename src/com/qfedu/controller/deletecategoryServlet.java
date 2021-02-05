package com.qfedu.controller;

import com.qfedu.service.CateService;
import com.qfedu.service.impl.CateserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletecategoryServlet")
public class deletecategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cid = request.getParameter("cid");
        CateService cateservice = new CateserviceImpl();
        cateservice.deleteByid(cid);
        response.sendRedirect(request.getContextPath() +"/CategoryServlet?pageNo=1");
    }
}
