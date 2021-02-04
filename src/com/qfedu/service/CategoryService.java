package com.qfedu.service;


import com.qfedu.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
	List<Category> findAllCategory()throws SQLException;
}
