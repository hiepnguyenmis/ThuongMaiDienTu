package com.shopping4th.ecommerce.rest;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Product;
import com.shopping4th.ecommerce.entity.Promotion;
import com.shopping4th.ecommerce.service.PromotionService;

@RestController
@RequestMapping(value="/api/promotions")
public class PromotionRest {

	@Autowired
	private PromotionService promotionService;
	
	@GetMapping
	public List<Promotion> getAllPromos(Pageable pageable){
		
		return this.promotionService.findAll(pageable);
	}
	
	
	@GetMapping(value="/{id}")
	public Promotion getPromo(@PathVariable Long id) {
		return this.promotionService.findById(id);
	}
	
	@DeleteMapping(value="/{id}")
	public void deletePromo(@PathVariable Long id) {
		
		boolean isPromo = this.promotionService.existsById(id);
		if(!isPromo) {
			throw new EntityNotFoundException("Promo id "+ id +" is not found");
		}
		this.promotionService.deleteById(id);
		
	}
	
	//Not yet checked
	@PutMapping("/{id}")
	public Promotion updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion) {
		if(!promotionService.existsById(id)) {
			throw new EntityNotFoundException("Promotion "+ id + " is not found");
		}
		
		promotion.setId(id);
		this.promotionService.save(promotion);
		return this.promotionService.findById(id);
	}
	
	//Not yet checked
	@PostMapping()
	public Promotion createProduct(@Valid @RequestBody Promotion promotion) {
		promotion.setCreatedAt(new Date());
		this.promotionService.save(promotion);
		return this.promotionService.findById(promotion.getId());
	}
}
