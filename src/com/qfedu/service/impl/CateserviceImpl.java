package com.qfedu.service.impl;

import com.qfedu.dao.impl.CategoryDaoImpl;
import com.qfedu.entity.Category;
import com.qfedu.service.CateService;

import java.util.List;

public class CateserviceImpl implements CateService {
    private CategoryDaoImpl categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> getall(int pageNo, int pageSize) {
        List<Category> getall = categoryDao.getall(pageNo, pageSize);
        return getall;
    }

    @Override
    public int cateCount() {

        int i = categoryDao.cateCount();
        return i;
    }

    @Override
    public int addcategory(int id ,String typename) {

        int i = categoryDao.addCategory(id, typename);
        return i;
    }

    @Override
    public int updateById(String id, String name) {
        int i = categoryDao.updateById(id, name);
        return i;
    }

    @Override
    public void deleteByid(String cid) {
        categoryDao.deleteByid(cid);
    }
}
