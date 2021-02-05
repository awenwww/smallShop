package com.qfedu.test;

import com.qfedu.entity.Order;
import com.qfedu.entity.OrderItem;
import com.qfedu.entity.Product;
import com.qfedu.service.impl.OrderServiceImpl;
import com.qfedu.service.impl.ProductServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class OrderTest {
    public static void main(String[] args) throws SQLException {
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        List<Order> allOrders = orderService.findAllOrders();
//        for (Order allOrder : allOrders) {
//            System.out.println(allOrder);
//        }
        ProductServiceImpl productService = new ProductServiceImpl();
        int dataCount = productService.selectDataCount();
        System.out.println(dataCount);
        List<Product> products = productService.selectAll(1, 30);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
