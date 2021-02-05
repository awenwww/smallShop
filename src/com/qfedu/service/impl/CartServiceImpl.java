package com.qfedu.service.impl;

import com.qfedu.dao.CartDao;
import com.qfedu.dao.impl.CartDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.service.CartService;
import com.qfedu.utils.DataSourceUtils;

import java.sql.SQLException;

public class CartServiceImpl implements CartService {

    @Override
    public void submitOrder(Order order) throws SQLException {
        CartDao dao = new CartDaoImpl();

        //1.开启事务
        try{

            DataSourceUtils.startTransaction();
            //2.调用dao方法
            dao.addOrder(order);
            dao.addOrderItems(order);
        }catch (SQLException e){
            DataSourceUtils.rollback();
        }finally{
            DataSourceUtils.commitAndRelease();
        }
    }
}
