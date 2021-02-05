package com.qfedu.dao;

import com.qfedu.entity.Order;

import java.sql.SQLException;

public interface CartDao {
    public void addOrder(Order order) throws SQLException;
    public void addOrderItems(Order order) throws SQLException;
}
