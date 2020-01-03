package com.shopping4th.ecommerce.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import com.shopping4th.ecommerce.entity.Product;
import com.shopping4th.ecommerce.service.ProductService;
import io.swagger.annotations.ApiResponse;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductRest {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products")
	public List<Product> getAllProduct(Pageable pageable){
		return this.productService.findAll(pageable);
	}
	
	@GetMapping("/products/newest")
	public List<Product> getAllProductNewest(Pageable pageable){
		return this.productService.findAllByOrderByCreatedAtDesc(pageable);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable Long id) {
		boolean isProduct = this.productService.existsById(id);
		if(!isProduct) {                                       
			throw new RuntimeException("Product "+ id + " is not found");
		}
		
		return productService.findById(id);
	}
	
	@GetMapping("/categories/{categoryId}/products")
	public List<Product> getProductByCategoryId(@PathVariable Long categoryId, Pageable pageable){
		return this.productService.findByCategoryId(categoryId, pageable);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		boolean isProduct = this.productService.existsById(id);
		if(!isProduct) {
			throw new RuntimeException("Product "+ id + " is not found");
		}
		
		productService.deletedById(id);
		
	}
	
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		if(!productService.existsById(id)) {
			throw new EntityNotFoundException("Product "+ id + " is not found");
		}
		
		product.setId(id);
		productService.save(product);
		return this.productService.findById(id);
	}
	
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		product.setCreatedAt(new Date());
		productService.save(product);
		return productService.findById(product.getId());
	}
	
	//Search
	@GetMapping(value="/products/search-by-range")
	public List<Product> searchByCategoryAndPrice(@RequestParam Long categoryId ,@RequestParam int type, Pageable pageable){
		List<Product> searchList= null;
		switch(type) {
			case 1:{
				searchList= this.productService.findByCategoryIdAndPriceLessThanEqual(categoryId, String.valueOf(10000000), pageable);
				break;
			}
			case 2:{
				searchList= this.productService.findByCategoryIdAndPriceBetween(categoryId, String.valueOf(10000000), String.valueOf(15000000), pageable);
				break;
			}
			case 3:{
				searchList= this.productService.findByCategoryIdAndPriceBetween(categoryId, String.valueOf(15000000), String.valueOf(25000000), pageable);

				break;
			}
		
		}
		return searchList;
	}
	
	@GetMapping(value = "/products/search-by-name")
	public ResponseEntity<List<Product>> searchByCategoryAndName(@RequestParam Long categoryId, @RequestParam String name, Pageable pageable){
		List<Product> searchList = this.productService.findByCategoryIdAndNameContaining(categoryId, name, pageable);
		if(searchList==null) {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(searchList);
	}
	
}
