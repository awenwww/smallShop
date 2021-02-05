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
    public int addType(String typename) {
        return 0;
    }

    @Override
    public int updateById(String id, String name) {
        int i = categoryDao.updateById(id, name);
        return i;
    }
}
