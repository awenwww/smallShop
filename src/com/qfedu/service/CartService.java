package com.qfedu.service;

import com.qfedu.entity.Order;

import java.sql.SQLException;

public interface CartService {
    public void submitOrder(Order order) throws SQLException;
}
