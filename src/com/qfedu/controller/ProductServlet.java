package com.qfedu.controller;

import com.qfedu.entity.OrderItem;
import com.qfedu.entity.User;
import com.qfedu.service.OrderService;
import com.qfedu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myOrderServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        String username = request.getParameter("u");
        OrderService orderService = new OrderServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            response.sendRedirect("login.jsp");
        }else {
            List<OrderItem> orders = orderService.selectUserOrder(user.getUsername());
            request.setAttribute("myOrders",orders);
            request.getRequestDispatcher("/order_list.jsp").forward(request,response);
        }

    }
}
