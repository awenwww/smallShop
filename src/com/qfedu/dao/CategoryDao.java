package com.qfedu.dao;

import com.qfedu.entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> getall(int pageNo , int pageSize , String str);
    public int typeCount();
    public int addType(String typename);
}
