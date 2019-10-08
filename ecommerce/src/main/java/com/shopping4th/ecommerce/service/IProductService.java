package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Product;

public interface IProductService {

	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public void save(Product product);
	
	public void deletedById(Long id);
	
	public boolean existsById(Long id);
}
