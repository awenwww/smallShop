package com.qfedu.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.dao.ProductDao;
import com.qfedu.entity.Product;
import com.qfedu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanListHandler;


public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> findNewsProduct() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="SELECT * FROM product ORDER BY pdate DESC LIMIT ?,?";
		List<Product> newsProducts = runner.query(sql, new BeanListHandler<Product>(Product.class),0,9);
		return newsProducts;
	}

	@Override
	public List<Product> findHotsProduct() throws SQLException{
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="SELECT * FROM product WHERE is_hot=? LIMIT ?,?";
		List<Product> hotProducts = runner.query(sql, new BeanListHandler<Product>(Product.class),1,0,9);
		return hotProducts;
	}


	

}
