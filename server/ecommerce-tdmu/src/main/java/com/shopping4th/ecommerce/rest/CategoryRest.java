package com.shopping4th.ecommerce.rest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Categories;
import com.shopping4th.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryRest {
	
	public static final Logger logger = LoggerFactory.getLogger(CategoryRest.class);
	private CategoryService categoryService;

	@Autowired
	public CategoryRest(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public List<Categories> getAllCategory(){
		return this.categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Categories getCategory(@PathVariable Long id) {
		logger.info("Fetching with id {}", id);
		boolean isCategory = this.categoryService.existsById(id);
		if(!isCategory) {
			logger.error("Product with id {} not found.", id);
			throw new RuntimeException("Category "+ id + " is not found");
		}
		
		return categoryService.findById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		boolean isCategory = this.categoryService.existsById(id);
		if(!isCategory) {
			throw new RuntimeException("Category "+ id + " is not found");
		}
		
		categoryService.deleteById(id);
		
		//return "Deleted category id "+ id;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public Categories updateCategory(@PathVariable Long id, @RequestBody Categories category) {
		if(!categoryService.existsById(id)) {
			throw new EntityNotFoundException("Category "+ id + " is not found");
		}
		
		category.setId(id);
		categoryService.save(category);
		return this.categoryService.findById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public Categories createCategory(@Valid @RequestBody Categories category) {
		
		categoryService.save(category);

		return categoryService.findById(category.getId());
	}
	
}
