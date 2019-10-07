package com.shopping4th.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.IProductRepo;
import com.shopping4th.ecommerce.entity.Product;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepo productRepo;
	
	public ProductService(IProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> findAll() {
		
		return productRepo.findAll();
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletedById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
 
	
}
