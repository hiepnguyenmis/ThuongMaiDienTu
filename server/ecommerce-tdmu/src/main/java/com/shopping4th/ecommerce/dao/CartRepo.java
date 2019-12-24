package com.shopping4th.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Carts;

@Repository
public interface CartRepo extends JpaRepository<Carts, Long> {

	public List<Carts> findByStatus(String status);
	public List<Carts> findByAccountId(Long id);
	public boolean existsByAccountId(Long accountId);
	public Carts findByAccountIdAndProductId(Long accountId, Long productId);

}
