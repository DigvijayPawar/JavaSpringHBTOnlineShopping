package com.app.shoping_backend.dao;

import java.util.List;

import com.app.shoping_backend.dto.Product;

public interface ProductDAO {
	
	List<Product> list();
	Product get(int id);
	boolean add(Product product); 
	boolean update(Product product); 
	boolean delete(Product product);
	
	//Business Methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	

}
