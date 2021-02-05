package com.qfedu.dao.impl;

import com.qfedu.dao.OrderDao;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderItem;
import com.qfedu.entity.Product;
import com.qfedu.utils.BaseDao1;
import com.qfedu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl extends BaseDao1 implements OrderDao {
    @Override
    public List<OrderItem> selectUserOrder(String username) {
        String sql="SELECT p.`pimage`,p.`pname`,p.`shop_price`,i.`count`,i.`subtotal`,o.`oid` FROM product p INNER JOIN orderitem i ON p.`pid`=i.`pid` INNER JOIN `orders` o ON i.`oid`=o.`oid` INNER JOIN `user` u ON o.`uid`=u.`uid` WHERE u.`username`=?";
        Object[] obj={username};
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while(resultSet.next()){
                OrderItem orderItem = new OrderItem();
                Order order = new Order();
                Product product = new Product();
                orderItem.setCount(resultSet.getInt("i.count"));
                orderItem.setSubtotal(resultSet.getDouble("i.subtotal"));
                order.setOid(resultSet.getString("o.oid"));
                orderItem.setOrder(order);
                product.setPimage(resultSet.getString("p.pimage"));
                product.setPname(resultSet.getString("p.pname"));
                product.setShop_price(resultSet.getDouble("p.shop_price"));
                orderItem.setProduct(product);
                orderItems.add(orderItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItems;
    }
    //后台订单
    @Override
    public List<Order> findAllOrders() throws SQLException {
        // TODO Auto-generated method stub
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from orders";
        return runner.query(sql, new BeanListHandler<Order>(Order.class));
    }

    @Override
    public List<Map<String, Object>> findItemByOid(String oid) throws SQLException {
        // TODO Auto-generated method stub
        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT p.`pimage`,p.`pname`,p.`shop_price`,o.`count`,o.`subtotal` FROM orderitem o,product p WHERE o.`pid`=p.`pid` AND o.`oid`=?";
        return runner.query(sql, new MapListHandler(),oid);
    }
}
