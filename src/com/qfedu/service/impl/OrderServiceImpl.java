package com.qfedu.service.impl;

import com.qfedu.dao.OrderDao;
import com.qfedu.dao.impl.OrderDaoImpl;
import com.qfedu.entity.OrderItem;
import com.qfedu.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public List<OrderItem> selectUserOrder(String username) {
        return orderDao.selectUserOrder(username);
    }
}
