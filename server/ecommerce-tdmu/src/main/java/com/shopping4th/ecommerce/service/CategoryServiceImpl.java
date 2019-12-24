package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.CategoryRepo;
import com.shopping4th.ecommerce.entity.Categories;


@Service
public class CategoryServiceImpl implements CategoryService {

	
    private CategoryRepo categoryRepo;
	
    @Autowired
	public CategoryServiceImpl(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@Override
	public List<Categories> findAll() {
		return this.categoryRepo.findAll();
	}

	@Override
	public Categories findById(Long id) {
		
		//return this.categoryRepo.findById(id).get();
		
		Optional<Categories> category = this.categoryRepo.findById(id);
		if(category.isPresent()) {
			return category.get();
		
		}
		else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void save(Categories category) {
		this.categoryRepo.save(category);
	}

	@Override
	public void deleteById(Long id) {
		//this.categoryRepo.deleteById(id);
		Optional<Categories> category = this.categoryRepo.findById(id);
		if(category.isPresent()) {
			
			this.categoryRepo.deleteById(id);
			
		}
	}

	@Override
	public boolean existsById(Long id) {
		return this.categoryRepo.existsById(id);
	}

	
}