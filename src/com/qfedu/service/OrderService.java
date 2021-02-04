package com.qfedu.service;

import com.qfedu.entity.OrderItem;

import java.util.List;

public interface OrderService {
    public List<OrderItem> selectUserOrder(String username);
}
