package com.app.shoping_backend.dao;

import java.util.List;

import com.app.shoping_backend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	boolean add(Category category);
	
}