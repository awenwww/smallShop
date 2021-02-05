package com.qfedu.dao.impl;

import com.qfedu.dao.CategoryDao;
import com.qfedu.entity.Category;
import com.qfedu.service.CateService;
import com.qfedu.service.impl.CateserviceImpl;
import com.qfedu.utils.BaseDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {


    @Override
    public List<Category> getall(int pageNo, int pageSize) {
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
    public int cateCount() {
        String sql = "select * from category";
        Object [] objects = {};
        List<Category> query = null;
        try {
            query = super.query(sql, objects, Category.class);
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


        return  query.size();
    }

    @Override
    public int updateById(String id,String name) {
        String sql = "update category set cname = ? where cid = ?";
        Object [] objects ={name , id};
        int update = 0;
        try {
             update = super.update(sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public List<Category> findAllCategory() {
        String sql = "select * from category";
        Object [] objects = {};
        List<Category> query = null;
        try {
            query = super.query(sql, objects, Category.class);
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


        return  query;
    }

    @Override
    public int addCategory(int id ,String string) {
        String sql = "insert into category (cid, cname) values(?,?)";
        Object [] obj ={id+10 ,string};
        int update = 0;
        try {
             update = super.update(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public void deleteByid(String cid) {
        String sql = "delete from category where cid = ?";
        Object [] objects = {cid};
        try {
            super.update(sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
