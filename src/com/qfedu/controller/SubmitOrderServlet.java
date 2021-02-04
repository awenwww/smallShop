package com.qfedu.controller;

import com.qfedu.entity.*;
import com.qfedu.service.CartService;
import com.qfedu.service.impl.CartServiceImpl;
import com.qfedu.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

@WebServlet("/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //判断用户是否登录
        User user = (User) request.getAttribute("user");
        if(user==null){
            //如果用户没有登录跳转到登录界面
            response.sendRedirect("login.jsp");
        }
        Order order=new Order();
        //将封装好的order传递给service层
		/*private String oid;//该订单的订单号
		private Date ordertime;//下单的时间
		private double total;//该订单的总金额
		private int state;//订单的支付状态 1表示已付款 0 表示未付款
		private String address;//商品的收获地址
		private String name;//收货人姓名
		private String telephone;//收货人电话
		private User user;//带订单属于哪个用户
*/
        order.setOid(UUIDUtils.getId());
        order.setOrdertime(new Date());
        //得到购物车session
        Cart cart = (Cart) request.getAttribute("cart");
        order.setTotal(cart.getTotal());
        order.setState(0);
        order.setAddress(null);
        order.setTelephone(null);
        order.setName(null);
        order.setUser(user);
        //添加订单项
        HashMap<String, CartItem> cartItems = cart.getCartItems();
        Set<String> keySet = cartItems.keySet();
        for (String key : keySet) {
            CartItem cartItem = cartItems.get(key);
            OrderItem orderItem=new OrderItem();
            orderItem.setCount(cartItem.getBuyNum());
            orderItem.setItemid(UUIDUtils.getId());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setSubtotal(cartItem.getSubTotal());
            orderItem.setOrder(order);
            order.getOrderItem().add(orderItem);
        }
        //封装完成以后 写到数据库
        CartService service=new CartServiceImpl();
        service.submitOrder(order);
        request.setAttribute("order", order);
        response.sendRedirect("order_info.jsp");

    }
}
