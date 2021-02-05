package com.qfedu.service;

import com.qfedu.entity.Category;

import java.util.List;

public interface CateService {
    public List<Category> getall(int pageNo , int pageSize);
    public int cateCount();
    public int addcategory(int id ,String typename);
    public int updateById(String id,String name);
    public void deleteByid(String cid);
}
