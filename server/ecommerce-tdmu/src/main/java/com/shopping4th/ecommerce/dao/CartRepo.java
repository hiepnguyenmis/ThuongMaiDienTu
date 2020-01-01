package com.shopping4th.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.CartItems;


@Repository
public interface CartRepo extends JpaRepository<CartItems, Long> {

	public List<CartItems> findByStatus(String status);
	public List<CartItems> findByAccountId(Long accountId);
	public List<CartItems> findByAccountIdAndStatus(Long accountId, String status);
	public boolean existsByAccountId(Long accountId);
	public boolean existsByAccountIdAndProductIdAndStatus(Long accountId, Long productId, String status);
	public CartItems findByAccountIdAndProductIdAndStatus(Long accountId, Long productId, String status);
	public void deleteById(Long cartItemId);

}
