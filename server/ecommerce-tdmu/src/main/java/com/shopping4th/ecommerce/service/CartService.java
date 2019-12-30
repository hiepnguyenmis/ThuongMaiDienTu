package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.CartItems;



public interface CartService {
	
	public List<CartItems> findAll();
	
	public CartItems findById(Long id);
	
	public void save(CartItems carts);
	
	public void deletedById(Long id);
	
	public boolean existsById(Long id);
	
	public void deleteAll(Long accountId);
	
	public CartItems findByAccountIdAndProductId(Long accountId, Long productId);
	
}
