package com.qfedu.controller;

import com.qfedu.service.CateService;
import com.qfedu.service.CategoryService;
import com.qfedu.service.impl.CategoryServiceImpl;
import com.qfedu.service.impl.CateserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminCategoryServlet")
public class adminCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cname = request.getParameter("cname");
        CateService cateservice = new CateserviceImpl();
        int i = cateservice.cateCount();
        int addcategory = cateservice.addcategory(i, cname);
        if (addcategory!=0){
            response.sendRedirect(request.getContextPath() +"/CategoryServlet?pageNo=1");
        }else{
            response.sendRedirect(request.getContextPath() +"/admi/catogory/add.jsp");
        }
    }
}
