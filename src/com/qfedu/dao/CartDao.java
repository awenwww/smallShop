package com.qfedu.dao;

import com.qfedu.entity.Order;

public interface CartDao {
    public void addOrder(Order order);
    public void addOrderItems(Order order);
}
