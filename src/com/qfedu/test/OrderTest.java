package com.qfedu.test;

import com.qfedu.entity.Order;
import com.qfedu.entity.OrderItem;
import com.qfedu.service.impl.OrderServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class OrderTest {
    public static void main(String[] args) throws SQLException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<Order> allOrders = orderService.findAllOrders();
        for (Order allOrder : allOrders) {
            System.out.println(allOrder);
        }
    }
}
