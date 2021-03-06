package com.qfedu.service;

import com.qfedu.entity.Order;
import com.qfedu.entity.OrderItem;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface OrderService {
    public List<OrderItem> selectUserOrder(String username);
    //后台订单
    List<Order> findAllOrders()throws SQLException;

    List<Map<String, Object>> findItemByOid(String oid)throws SQLException;
    void updateOrder(Order order) throws SQLException;
    void updateOrderState(String oid,int i) throws SQLException;
}
