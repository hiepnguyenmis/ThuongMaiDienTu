package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Categories;

public interface ICategoryService {

	public List<Categories> findAll();
	
	public Categories findById(Long id);
	
	public void save(Categories category);
	
	public void deletedById(Long id);
	
	public boolean existsById(Long id);
	
	
	
	
}
