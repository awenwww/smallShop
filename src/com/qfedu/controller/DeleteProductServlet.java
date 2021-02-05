package com.qfedu.controller;

import com.qfedu.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // response.sendRedirect("text/html;charset=utf-8");
        String pid = request.getParameter("pid");
        System.out.println(pid);
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.delete(pid);
        response.sendRedirect("FuzzySelectProducts");
        return;
    }
}
