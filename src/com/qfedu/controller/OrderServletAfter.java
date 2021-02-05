package com.qfedu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.entity.Order;
import com.qfedu.service.impl.OrderServiceImpl;
import com.qfedu.utils.BaseServlet;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/OrderServletAfter")
public class OrderServletAfter extends BaseServlet {

    /**
     *
     */
    public void findAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //查找所有的订单
        OrderServiceImpl orderService = new OrderServiceImpl();
        try {
            List<Order> orders=orderService.findAllOrders();
            request.setAttribute("adminOrders", orders);
//			response.sendRedirect("admin/order/list.jsp");
            request.getRequestDispatcher("admin/order/list.jsp").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void findItemByOid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //点击按钮通过oid查询商品详情
        OrderServiceImpl orderService = new OrderServiceImpl();
        String oid=request.getParameter("oid");
//		System.out.println(oid);
        try {
            List<Map<String,Object>> mapList=orderService.findItemByOid(oid);
            //把集合转换成json字符串
            String jsonItem=JSONArray.fromObject(mapList).toString();
//			System.out.println(jsonItem);
            //把数据写到前端
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(jsonItem);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
