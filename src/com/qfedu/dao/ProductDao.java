package com.qfedu.dao;

import java.sql.SQLException;
import java.util.List;
import com.qfedu.entity.Product;

public interface ProductDao {
	 //获取最新商品的
	List<Product> findNewsProduct() throws SQLException;
	//获取最热商品的
	List<Product> findHotsProduct() throws SQLException;
}
