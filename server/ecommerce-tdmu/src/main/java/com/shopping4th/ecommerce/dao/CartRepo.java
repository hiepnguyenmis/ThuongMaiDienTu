package com.shopping4th.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.CartItems;


@Repository
public interface CartRepo extends JpaRepository<CartItems, Long> {

	public List<CartItems> findByStatus(String status);
	public List<CartItems> findByAccountId(Long id);
	public boolean existsByAccountId(Long accountId);
	public CartItems findByAccountIdAndProductId(Long accountId, Long productId);
	public void deleteById(Long cartItemId);

}
