package com.qfedu.service.impl;

import com.qfedu.dao.ProductDao;
import com.qfedu.dao.impl.ProductDaoImpl;
import com.qfedu.entity.PageBean;
import com.qfedu.entity.Product;
import com.qfedu.service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
    @Override
    public PageBean<Product> findByCategoryProduct(String cid, String currentPage) throws SQLException {
        // TODO Auto-generated method stub
        PageBean<Product> page=new PageBean<>();
        ProductDao dao=new ProductDaoImpl();
        //封装当前页的数量
        int currentCount =12;
        //封装当前页数
        int currentpage;
        if(currentPage==null||"".equals(currentPage)){
            currentpage=1;
        }else{
            currentpage=Integer.parseInt(currentPage);
        }
        //得到该类商品的查询总数
        int count=dao.findByCategoryCount(cid);
        //得到显示的总页数
        int totalPage=(int) Math.ceil((double)count/(double)currentCount);
//		System.out.println(totalPage);
        //得到显示的起始位置
        int index=(currentpage-1)*currentCount;
        //查找需要显示的商品
        page=dao.findByCategoryProduct(cid, index, currentCount);
        page.setCurrentCount(currentCount);
        page.setCurrentPage(currentpage);
        page.setTotalPage(totalPage);
        page.setTotalCount(count);
//		System.out.println(page);
        return page;
    }

    @Override
    public Product findProInfoById(String pid) throws SQLException {
        // TODO Auto-generated method stub
        ProductDao dao=new ProductDaoImpl();
        Product pro = dao.findProInfoById(pid);

        return pro;
    }
    @Override
    public List<Map<String, Object>> findItemsByOid(String oid) throws SQLException {
        // TODO Auto-generated method stub
        ProductDao dao=new ProductDaoImpl();
        return dao.findItemsByOid(oid);
    }

    @Override
    public List<Product> selectAll(int pageNo, int pageSize) {
        ProductDao dao=new ProductDaoImpl();
        List<Product> products = dao.selectAll(pageNo, pageSize);
        return products;
    }

    @Override
    public int selectDataCount() {
        ProductDao dao=new ProductDaoImpl();
        int dataCount = dao.selectDataCount();
        return dataCount;
    }

    @Override
    public void update(Product p) throws SQLException {
        ProductDao dao=new ProductDaoImpl();
        dao.update(p);
    }

    @Override
    public Product getProductsById(int id) {
        ProductDao dao=new ProductDaoImpl();
        Product productsById = dao.getProductsById(id);
        return productsById;
    }

    @Override
    public void delete(String id) {
        ProductDao dao=new ProductDaoImpl();
        dao.delete(id);
    }
}
