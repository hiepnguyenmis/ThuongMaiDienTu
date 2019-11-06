package com.shopping4th.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Product;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {

	public Page<Product> findAll(Pageable pageable);
	public List<Product> findByCategoryId(Long categoryId);
}
