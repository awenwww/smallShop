package com.qfedu.service.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.dao.OrderDao;
import com.qfedu.dao.impl.OrderDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderItem;
import com.qfedu.service.OrderService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public List<OrderItem> selectUserOrder(String username) {
        return orderDao.selectUserOrder(username);
    }
    //后台订单
    @Override
    public List<Order> findAllOrders() throws SQLException {
        // TODO Auto-generated method stub
        OrderDaoImpl orderDao = new OrderDaoImpl();
        return orderDao.findAllOrders();
    }

    @Override
    public List<Map<String, Object>> findItemByOid(String oid) throws SQLException {
        // TODO Auto-generated method stub
        OrderDaoImpl orderDao = new OrderDaoImpl();

        return orderDao.findItemByOid(oid);
    }
    @Override
    public void updateOrder(Order order) throws SQLException {
        // TODO Auto-generated method stub
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.updateOrder(order);
    }

    @Override
    public void updateOrderState(String oid, int i) throws SQLException {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.updateOrderState(oid,i);
    }
}
