package com.qfedu.service;

import com.qfedu.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    //获取最新商品
    List<Product> findNewsProduct() throws SQLException;
    //获取最热商品的
    List<Product> findHotsProduct() throws SQLException;
}
