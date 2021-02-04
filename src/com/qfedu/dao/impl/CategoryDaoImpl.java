package com.qfedu.dao.impl;

import com.qfedu.dao.CategoryDao;
import com.qfedu.entity.Category;
import com.qfedu.utils.BaseDao;

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
}
