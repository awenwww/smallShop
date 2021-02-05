package com.qfedu.controller;

import com.qfedu.entity.Product;
import com.qfedu.service.impl.ProductServiceImpl;
import com.qfedu.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FuzzySelectProducts")
public class FuzzySelectProducts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ProductServiceImpl productService = new ProductServiceImpl();

        String pNo = request.getParameter("pageNo");
        if(pNo == null ||pNo =="") {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 15;
        int dataCount = productService.selectDataCount();

        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dataCount);
        int pageCount = pageUtil.getPageCount();

        List<Product> products = productService.selectAll(pageNo,pageSize);

        request.setAttribute("list",products);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount", pageCount);
        request.getRequestDispatcher("/admin/product/list.jsp").forward(request , response);
    }
}
