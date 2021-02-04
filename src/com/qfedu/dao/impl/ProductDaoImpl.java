package com.qfedu.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.dao.ProductDao;
import com.qfedu.entity.PageBean;
import com.qfedu.entity.Product;
import com.qfedu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


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
	@Override
	public PageBean<Product> findByCategoryProduct(String cid, int index, int currentCount) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		PageBean<Product> pageBean = new PageBean<>();
		String sql = "SELECT * FROM product WHERE cid=? LIMIT ?,?";
		List<Product> hotProducts
				= runner.query(sql, new BeanListHandler<Product>(Product.class), cid, index, currentCount);
		pageBean.setList(hotProducts);
		return pageBean;
	}

	@Override
	public int findByCategoryCount(String cid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT COUNT(*) FROM product WHERE cid=?";
		Long count = (Long) runner.query(sql, new ScalarHandler(), cid);
		return count.intValue();
	}

	@Override
	public Product findProInfoById(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = "SELECT * FROM product WHERE pid=?";
		Product pro = runner.query(sql, new BeanHandler<Product>(Product.class), pid);

		return pro;
	}

	@Override
	public List<Map<String, Object>> findItemsByOid(String oid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT p.`pimage`,p.`pname`,p.`shop_price`,o.`count`,o.`subtotal` "
				+ "FROM orderitem o,product p WHERE o.`pid`=p.`pid` AND o.`oid`=?";

		return runner.query(sql, new MapListHandler(), oid);
	}

	

}
