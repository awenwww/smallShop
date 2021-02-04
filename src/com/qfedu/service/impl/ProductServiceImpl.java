package com.qfedu.service.impl;

import com.qfedu.dao.ProductDao;
import com.qfedu.dao.impl.ProductDaoImpl;
import com.qfedu.entity.Product;
import com.qfedu.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> findNewsProduct() throws SQLException {
        // TODO Auto-generated method stub
        ProductDao dao=new ProductDaoImpl();
        return dao.findNewsProduct();
    }

    @Override
    public List<Product> findHotsProduct() throws SQLException {
        // TODO Auto-generated method stub
        ProductDao dao=new ProductDaoImpl();


        return dao.findHotsProduct();
    }
}
