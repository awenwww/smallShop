package com.qfedu.dao.impl;

import com.qfedu.dao.CategoryDao;
import com.qfedu.entity.Category;
import com.qfedu.utils.BaseDao;
import com.qfedu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

    @Override
    public List<Category> getall(int pageNo, int pageSize, String str) {
       String sql = "select * from category limit ?,?";
        Object [] objects = {(pageNo-1) * pageSize , pageSize};
        List<Category> query = null;
        try {
            query = super.query(sql, objects, Category.class);
            return query;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int typeCount() {
        return 0;
    }

    @Override
    public int addType(String typename) {
        return 0;
    }
    @Override
    public List<Category> findAllCategory() throws SQLException {
        // TODO Auto-generated method stub

        QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="SELECT * FROM category";
        List<Category> allCategory = runner.query(sql, new BeanListHandler<Category>(Category.class));
        return allCategory;

    }
}
