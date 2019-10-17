package com.shopping4th.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Accounts;

@Repository
public interface AccountRepo extends JpaRepository<Accounts, Long>{

	public Accounts findByEmail(String email);
	public boolean existsByEmail(String email);
}
