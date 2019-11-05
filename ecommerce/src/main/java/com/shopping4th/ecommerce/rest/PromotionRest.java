package com.shopping4th.ecommerce.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public String deletePromo(@PathVariable Long id) {
		
		boolean isPromo = this.promotionService.existById(id);
		if(!isPromo) {
			throw new EntityNotFoundException("Promo id "+ id +" is not found");
		}
		this.promotionService.deleteById(id);
		return "Deleted promo id "+ id;
	}
}
