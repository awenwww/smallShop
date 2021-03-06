package com.qfedu.dao.impl;

import com.qfedu.dao.CartDao;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderItem;
import com.qfedu.utils.BaseDao1;
import com.qfedu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class CartDaoImpl extends BaseDao1 implements CartDao {

    @Override
    public void addOrder(Order order) throws SQLException {
        /*String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        Object[] objects = {order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),
                order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid()};
        int i = super.setUpdate(sql, objects);
        if (i!=0){
            System.out.println("addOrder方法成功！");
        }*/
        QueryRunner runner=new QueryRunner();
        java.sql.Connection conn= DataSourceUtils.getConnection();
        String sql="insert into orders values(?,?,?,?,?,?,?,?)";
        runner.update(conn, sql, order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),
                order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid());

    }

    @Override
    public void addOrderItems(Order order) throws SQLException {
        /*String sql = "insert into orderitem values(?,?,?,?,?)";
        int i=0;
        for (OrderItem orderItem:order.getOrderItem()) {
            Object[] objects = {orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),
                    orderItem.getProduct().getPid(),orderItem.getOrder().getOid()};
            i=super.setUpdate(sql,objects);
        }
        if (i!=0){
            System.out.println("addOrderItems方法成功！");
        }*/
        QueryRunner runner=new QueryRunner();
        String sql="insert into orderitem values(?,?,?,?,?)";
        java.sql.Connection conn= DataSourceUtils.getConnection();
        for(OrderItem orderItem:order.getOrderItem()){
            runner.update(conn, sql,orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),
                    orderItem.getProduct().getPid(),orderItem.getOrder().getOid());
        }
    }
}
