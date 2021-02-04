package com.qfedu.test;

import com.qfedu.entity.OrderItem;
import com.qfedu.service.impl.OrderServiceImpl;

import java.util.List;

public class OrderTest {
    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<OrderItem> orderItems = orderService.selectUserOrder("flz");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }
}
