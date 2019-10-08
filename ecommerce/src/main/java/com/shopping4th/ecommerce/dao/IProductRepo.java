package com.shopping4th.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Product;

@Repository
public interface IProductRepo extends JpaRepository<Product, Long> {

	Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
}
