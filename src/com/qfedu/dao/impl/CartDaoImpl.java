package com.qfedu.dao.impl;

import com.qfedu.dao.CartDao;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderItem;
import com.qfedu.utils.BaseDao1;

public class CartDaoImpl extends BaseDao1 implements CartDao {

    @Override
    public void addOrder(Order order) {
        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        Object[] objects = {order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),
                order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid()};
        int i = super.setUpdate(sql, objects);
        if (i!=0){
            System.out.println("addOrder方法成功！");
        }

    }

    @Override
    public void addOrderItems(Order order) {
        String sql = "insert into orderitem values(?,?,?,?,?)";
        int i=0;
        for (OrderItem orderItem:order.getOrderItem()) {
            Object[] objects = {orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),
                    orderItem.getProduct().getPid(),orderItem.getOrder().getOid()};
            i=super.setUpdate(sql,objects);
        }
        if (i!=0){
            System.out.println("addOrderItems方法成功！");
        }
    }
}
