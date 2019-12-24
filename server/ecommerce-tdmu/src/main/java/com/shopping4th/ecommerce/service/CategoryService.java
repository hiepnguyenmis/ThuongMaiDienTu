package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Categories;

public interface CategoryService {

	public List<Categories> findAll();
	
	public Categories findById(Long id);
	
	public void save(Categories category);
	
	public void deleteById(Long id);
	
	public boolean existsById(Long id);
	
	
	
	
}
