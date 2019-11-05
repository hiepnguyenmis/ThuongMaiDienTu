package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.ImageRepo;
import com.shopping4th.ecommerce.entity.Images;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepo imageRepo;
	
	

	@Override
	public List<Images> findByProductId(Long productId) {
		return this.imageRepo.findByProductId(productId);
	}



	@Override
	public Optional<Images> findByIdAndProductId(Long id, Long productId) {
		return this.imageRepo.findByIdAndProductId(id, productId);
	}
	
	

}
