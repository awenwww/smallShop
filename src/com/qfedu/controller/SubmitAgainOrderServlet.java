package com.qfedu.controller;

import com.qfedu.entity.Order;
import com.qfedu.service.OrderService;
import com.qfedu.service.ProductService;
import com.qfedu.service.impl.OrderServiceImpl;
import com.qfedu.service.impl.ProductServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/SubmitAgainOrderServlet")
public class SubmitAgainOrderServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得传过来的地址收货人等
        Map<String, String[]> map = request.getParameterMap();
        Order order=new Order();
        //将得到数据封装进去
        try {
            BeanUtils.populate(order, map);
            OrderService service=new OrderServiceImpl();
            service.updateOrder(order);
            //下一步第三方支付平台，这里的话就默认自动支付成功然后修改订单状态
            service.updateOrderState(order.getOid(), 1);
            response.sendRedirect(request.getContextPath()+"/myOrderServlet");


        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
