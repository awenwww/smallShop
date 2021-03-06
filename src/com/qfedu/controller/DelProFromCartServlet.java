package com.qfedu.controller;

import com.qfedu.entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/DelProFromCartServlet")
public class DelProFromCartServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        //得到要删除的商品Id
        String pid=request.getParameter("pid");
        //得到购物车session
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart!=null){
            //得到该商品的小计
            double subTotal=cart.getCartItems().get(pid).getSubTotal();
            //移除该商品
            cart.getCartItems().remove(pid);
            //改变总价
            cart.setTotal(cart.getTotal()-subTotal);

            session.setAttribute("cart", cart);
            response.sendRedirect("cart.jsp");
        }

    }
}
