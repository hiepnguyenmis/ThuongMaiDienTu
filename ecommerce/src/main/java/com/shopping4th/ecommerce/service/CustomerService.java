package com.shopping4th.ecommerce.service;

import java.util.List;

import com.shopping4th.ecommerce.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer findById(Long id);
	
	public void save(Customer customer);
	
	public void deletedById(Long id);
	
	public boolean existsById(Long id); 

}
