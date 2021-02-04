package com.qfedu.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.entity.PageBean;
import com.qfedu.entity.Product;

public interface ProductDao {
	 //获取最新商品的
	List<Product> findNewsProduct() throws SQLException;
	//获取最热商品的
	List<Product> findHotsProduct() throws SQLException;
	//根据商品类别查找商品分页显示
	PageBean<Product> findByCategoryProduct(String cid, int index, int currentCount) throws SQLException;

	//查询这个类别的所有商品总数
	int findByCategoryCount(String cid) throws SQLException;
	//根据商品类别查找商品分页显示
	Product findProInfoById(String pid) throws SQLException;
	List<Map<String, Object>> findItemsByOid(String oid) throws SQLException;
}
