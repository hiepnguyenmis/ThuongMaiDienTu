package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.PromotionRepo;
import com.shopping4th.ecommerce.entity.Promotion;

@Service
public class PromotionServiceImpl implements PromotionService {

	
	private PromotionRepo promotionRepo;
	@Autowired
	public PromotionServiceImpl(PromotionRepo promotionRepo) {
		this.promotionRepo = promotionRepo;
	}

	@Override
	public List<Promotion> findAll() {
		return this.promotionRepo.findAll();
	}

	@Override
	public Promotion findById(Long id) {
		Optional<Promotion> promo = this.promotionRepo.findById(id);
		if(promo.isPresent()) {
			return promo.get();
		}
		else {
			throw new EntityNotFoundException("Not found promo with id: " + id);
		}
	}

	@Override
	public void save(Promotion promotion) {
		this.promotionRepo.save(promotion);
	}

	@Override
	public void deleteById(Long id) {
		this.promotionRepo.deleteById(id);
		
	}

	@Override
	public boolean existsById(Long id) {
		return this.promotionRepo.existsById(id);
	}

	@Override
	public List<Promotion> findAll(Pageable pageable) {
		Page<Promotion> promo = this.promotionRepo.findAll(pageable);
		return promo.getContent();
	}

}
