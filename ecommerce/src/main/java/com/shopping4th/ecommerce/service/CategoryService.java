package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.ICategoryRepo;
import com.shopping4th.ecommerce.entity.Category;


@Service
public class CategoryService implements ICategoryService {

    private ICategoryRepo categoryRepo;
    
    public CategoryService(ICategoryRepo categoryRepo) {
		
		this.categoryRepo = categoryRepo;
	}

	@Override
	public List<Category> findAll() {
		return this.categoryRepo.findAll();
	}

	@Override
	public Category findById(int id) {
		return null;
	}

	@Override
	public void save(Category category) {
		this.categoryRepo.save(category);
	}

	@Override
	public void deletedById(int id) {
		this.categoryRepo.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {
		return this.categoryRepo.existsById(id);
	}

	
}