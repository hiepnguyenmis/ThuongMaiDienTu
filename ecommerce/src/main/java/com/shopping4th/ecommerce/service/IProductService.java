package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Category;
import com.shopping4th.ecommerce.entity.Product;

public interface IProductService {

	public List<Product> findAll();
	
	public Product findById(int id);
	
	public void save(Product product);
	
	public void deletedById(int id);
	
	public boolean existsById(int id);
}
