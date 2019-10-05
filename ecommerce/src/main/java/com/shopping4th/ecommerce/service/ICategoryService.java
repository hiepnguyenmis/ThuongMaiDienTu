package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Category;

public interface ICategoryService {

	public List<Category> findAll();
	
	public Category findById(int id);
	
	public void save(Category category);
	
	public void deletedById(int id);
	
	public boolean existsById(int id);
	
	
}
