package com.shopping4th.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Images;

@Repository
public interface ImageRepo extends JpaRepository<Images, Long> {

	Optional<Images> findByIdAndProductId(Long id, Long productId);
	public List<Images> findByProductId(Long productId);
}
