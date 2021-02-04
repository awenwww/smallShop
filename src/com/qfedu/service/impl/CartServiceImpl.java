package com.qfedu.service.impl;

import com.qfedu.dao.CartDao;
import com.qfedu.dao.impl.CartDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.service.CartService;

public class CartServiceImpl implements CartService {

    @Override
    public void submitOrder(Order order) {
        CartDao cartDao = new CartDaoImpl();
        cartDao.addOrder(order);
        cartDao.addOrderItems(order);
    }
}
