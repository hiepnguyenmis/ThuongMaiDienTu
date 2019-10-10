package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Category;

public interface ICategoryService {

	public List<Category> findAll();
	
	public Category findById(Long id);
	
	public void save(Category category);
	
	public void deletedById(Long id);
	
	public boolean existsById(Long id);
	
	
	
}
