package com.shopping4th.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.shopping4th.ecommerce.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public void save(Product product);
	
	public void deletedById(Long id);
	
	public boolean existsById(Long id);
	
	public List<Product> findAll(Pageable pageable);
		
	public List<Product> findByCategoryId(Long categoryId, Pageable pageable);
	
	public List<Product> findByCategoryIdAndPriceLessThanEqual(Long categoryId, String price, Pageable pageable);
	
	public List<Product> findByCategoryIdAndPriceBetween(Long categoryId, String minPrice, String maxPrice, Pageable pageable);
	
	public List<Product> findByCategoryIdAndNameContaining(Long categoryId, String keyword, Pageable pageable);
}
