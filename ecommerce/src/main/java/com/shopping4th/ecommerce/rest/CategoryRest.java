package com.shopping4th.ecommerce.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("")
	public List<Category> getAll(){
		return this.categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Category getById(@PathVariable int id) {
		boolean isCategory = this.categoryService.existsById(id);
		if(!isCategory) {
			throw new RuntimeException("Category "+ id + " is not found");
		}
		System.out.println(categoryService.findById(id));
		return categoryService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		boolean isCategory = this.categoryService.existsById(id);
		if(!isCategory) {
			throw new RuntimeException("Category "+ id + " is not found");
		}
		
		categoryService.deletedById(id);
		return "Deleted category id "+ id;
	}
	
	

}
