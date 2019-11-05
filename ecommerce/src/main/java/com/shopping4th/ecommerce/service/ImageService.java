package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.shopping4th.ecommerce.entity.Images;

public interface ImageService {

	public List<Images> findByProductId(Long productId);
	public Optional<Images> findByIdAndProductId(Long id, Long productId);
}
