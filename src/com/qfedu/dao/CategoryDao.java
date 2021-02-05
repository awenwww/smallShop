package com.qfedu.dao;

import com.qfedu.entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> getall(int pageNo , int pageSize );
    public int cateCount();
    public int updateById(String id,String name);
    public List<Category> findAllCategory();
}
