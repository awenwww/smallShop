package com.qfedu.dao;

import com.qfedu.entity.OrderItem;

import java.util.List;

public interface OrderDao {
    public List<OrderItem> selectUserOrder(String username);
}
