package com.qfedu.dao;

import com.qfedu.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    public List<Category> getall(int pageNo , int pageSize );
    public int cateCount();
    public int updateById(String id,String name);
    public List<Category> findAllCategory() throws SQLException;
    public int addCategory(int id ,String string);
    public void deleteByid(String cid);
    public List<Category> getall(int pageNo , int pageSize , String str);
    public int typeCount();
    public int addType(String typename);
}
