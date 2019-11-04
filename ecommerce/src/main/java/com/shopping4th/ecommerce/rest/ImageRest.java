package com.shopping4th.ecommerce.rest;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Images;
import com.shopping4th.ecommerce.service.ImageService;
import com.shopping4th.ecommerce.service.ProductService;

@RestController
@RequestMapping(value ="/api")
@CrossOrigin
public class ImageRest {

	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value ="/products/{productId}/images")
	public List<Images> getAllImagesByProductId(@PathVariable Long productId){
		return this.imageService.findByProductId(productId);
	}
	
	@GetMapping(value = "/products/{productId}/images/{imageId}")
	public Images getImagedById(@PathVariable Long productId, @PathVariable Long imageId) {
		Optional<Images> image = this.imageService.findByIdAndProductId(imageId, productId);
		if(image.isPresent()) {
			return image.get();
		}
		else {
			throw new EntityNotFoundException("Image not found with id " + imageId);
		}
	}
}
