package com.shopping4th.ecommerce.rest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Category;
import com.shopping4th.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryRest {
	
	private CategoryService categoryService;

	@Autowired
	public CategoryRest(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<Category> getAllCategory(){
		return this.categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable Long id) {
		boolean isCategory = this.categoryService.existsById(id);
		if(!isCategory) {
			throw new RuntimeException("Category "+ id + " is not found");
		}
		
		return categoryService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		boolean isCategory = this.categoryService.existsById(id);
		if(!isCategory) {
			throw new RuntimeException("Category "+ id + " is not found");
		}
		
		categoryService.deletedById(id);
		//return "Deleted category id "+ id;
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
		if(!categoryService.existsById(id)) {
			throw new EntityNotFoundException("Category "+ id + " is not found");
		}
		
		category.setId(id);
		categoryService.save(category);
		return this.categoryService.findById(id);
	}
	
	@PostMapping
	public Category createCategory(@Valid @RequestBody Category category) {
		category.setCreatedAt(new Date());
		categoryService.save(category);
		
		System.out.println(category.getCreatedAt());
		return categoryService.findById(category.getId());
	}
	
	
	

}
