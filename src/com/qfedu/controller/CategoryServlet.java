package com.qfedu.controller;

import com.qfedu.entity.Category;
import com.qfedu.service.CateService;
import com.qfedu.service.impl.CateserviceImpl;
import com.qfedu.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CateService cateservice = new CateserviceImpl();

        String pNo = request.getParameter("pageNo");
        if(pNo == null ||pNo =="") {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 3;
        int cateCount = cateservice.cateCount();

        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(cateCount);
        int pageCount = pageUtil.getPageCount();

        List<Category> getall = cateservice.getall(pageNo, pageSize);

        request.setAttribute("list",getall);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount", pageCount);
       request.getRequestDispatcher("/admin/category/list.jsp").forward(request , response);


    }
}
