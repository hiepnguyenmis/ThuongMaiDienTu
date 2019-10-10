package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.ICategoryRepo;
import com.shopping4th.ecommerce.entity.Category;


@Service
public class CategoryService implements ICategoryService {

	@Autowired
    private ICategoryRepo categoryRepo;
    
//    public CategoryService(ICategoryRepo categoryRepo) {
//		
//		this.categoryRepo = categoryRepo;
//	}

	@Override
	public List<Category> findAll() {
		return this.categoryRepo.findAll();
	}

	@Override
	public Category findById(Long id) {
		
		//return this.categoryRepo.findById(id).get();
		
		Optional<Category> category = this.categoryRepo.findById(id);
		if(category.isPresent()) {
			return category.get();
		
		}
		else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void save(Category category) {
		this.categoryRepo.save(category);
	}

	@Override
	public void deletedById(Long id) {
		this.categoryRepo.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return this.categoryRepo.existsById(id);
	}

	
}