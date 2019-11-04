package com.shopping4th.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.shopping4th.ecommerce.entity.Promotion;

public interface PromotionService {

	public List<Promotion> findAll();
	public List<Promotion> findAll(Pageable pageable);
	public Promotion findById(Long id);
	public void save(Promotion promotion);
	public void deleteById(Long id);
	public boolean existById(Long id);
	
}
