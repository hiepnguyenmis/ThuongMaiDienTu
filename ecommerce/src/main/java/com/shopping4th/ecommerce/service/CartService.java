package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Carts;


public interface CartService {
	
	public List<Carts> findAll();
	
	public Carts findById(Long id);
	
	public void save(Carts carts);
	
	public void deletedById(Long id);
	
	public boolean existsById(Long id);
	
	public void deleteAll(Long accountId);
	
	public Carts findByAccountIdAndProductId(Long accountId, Long productId);
}
