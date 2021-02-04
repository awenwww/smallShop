package com.qfedu.service;

import com.qfedu.entity.PageBean;
import com.qfedu.entity.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ProductService {
    //获取最新商品
    List<Product> findNewsProduct() throws SQLException;
    //获取最热商品的
    List<Product> findHotsProduct() throws SQLException;
    //根据商品类别查找商品分页显示
    PageBean<Product> findByCategoryProduct(String cid, String currentPage) throws SQLException;
    //根据商品类别查找商品分页显示
    Product findProInfoById(String pid) throws SQLException;
    List<Map<String, Object>> findItemsByOid(String oid) throws SQLException;
}
