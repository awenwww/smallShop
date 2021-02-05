package com.qfedu.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qfedu.dao.ProductDao;
import com.qfedu.entity.PageBean;
import com.qfedu.entity.Product;
import com.qfedu.utils.BaseDao;
import com.qfedu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


public class ProductDaoImpl extends BaseDao implements ProductDao{

	QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
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
		String sql="SELECT * FROM product WHERE is_hot=? LIMIT ?,?";
		List<Product> hotProducts = runner.query(sql, new BeanListHandler<Product>(Product.class),1,0,9);
		return hotProducts;
	}

	@Override
	public PageBean<Product> findByCategoryProduct(String cid, int index, int currentCount) throws SQLException {
		// TODO Auto-generated method stub

		PageBean<Product> pageBean=new PageBean<>();
		String sql="SELECT * FROM product WHERE cid=? LIMIT ?,?";
		List<Product> hotProducts
				= runner.query(sql, new BeanListHandler<Product>(Product.class),cid,index,currentCount);
		pageBean.setList(hotProducts);
		return pageBean;
	}

	@Override
	public int findByCategoryCount(String cid) throws SQLException {
		// TODO Auto-generated method stub

		String sql="SELECT COUNT(*) FROM product WHERE cid=?";
		Long count=(Long) runner.query(sql, new ScalarHandler(),cid);
		return count.intValue();
	}

	@Override
	public Product findProInfoById(String pid) throws SQLException {
		// TODO Auto-generated method stub


		String sql="SELECT * FROM product WHERE pid=?";
		Product pro= runner.query(sql, new BeanHandler<Product>(Product.class),pid);

		return pro;
	}

	@Override
	public List<Map<String, Object>> findItemsByOid(String oid) throws SQLException {
		// TODO Auto-generated method stub

		String sql="SELECT p.`pimage`,p.`pname`,p.`shop_price`,o.`count`,o.`subtotal` "
				+ "FROM orderitem o,product p WHERE o.`pid`=p.`pid` AND o.`oid`=?";

		return runner.query(sql, new MapListHandler(),oid);
	}

	//后台商品
	@Override
	public List<Product> selectAll(int pageNo, int pageSize) {
		String sql = "select * from product left join category on product.cid = category.cid where 1=1 " + " limit ?, ?";
		Object[] obj = {(pageNo-1)*pageSize, pageSize};
		try {
			List<Product> query = super.query(sql, obj,Product.class);
			return query;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selectDataCount() {
		String sql = "select * from product left join category on product.cid = category.cid where 1=1 ";
		Object[] obj ={};
		try {
			List<Product> query = super.query(sql, obj, Product.class);
			return query.size();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public void update(Product p) throws SQLException {
		String sql="update product set pname=?,market_price=?,is_hot=?,pdesc=?,pflag=?,cid=?,shop_price=? where pid=?";
		runner.update(sql,p.getPname(),p.getMarket_price(),p.getIs_hot(),p.getPdesc(),p.getPflag(),
				p.getCategory().getCid(),p.getShop_price(),p.getPid());
	}

	@Override
	public Product getProductsById(int id) {
		String sql = "select * from product  where pid =?";
		Object[] parameters = {id};
		try {
			List<Product> query = super.query(sql, parameters, Product.class);
			return query.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(String id) {
		String sql="delete from product where pid = ?";
		Object[] parameter ={id};
		try {
			super.update(sql,parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
