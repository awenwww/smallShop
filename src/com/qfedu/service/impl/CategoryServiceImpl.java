package com.qfedu.service.impl;



import com.qfedu.dao.CategoryDao;
import com.qfedu.dao.impl.CategoryDaoImpl;
import com.qfedu.entity.Category;
import com.qfedu.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> findAllCategory() throws SQLException {
		// TODO Auto-generated method stub
		CategoryDao dao=new CategoryDaoImpl();
		return dao.findAllCategory();
	}

}
