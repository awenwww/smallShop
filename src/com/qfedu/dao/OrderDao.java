package com.qfedu.dao;

import com.qfedu.entity.Order;
import com.qfedu.entity.OrderItem;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface OrderDao {
    public List<OrderItem> selectUserOrder(String username);
    //订单
    List<Order> findAllOrders()throws SQLException;
    List<Map<String, Object>> findItemByOid(String oid)throws SQLException;
}
