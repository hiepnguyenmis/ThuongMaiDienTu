package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.AccountRepo;
import com.shopping4th.ecommerce.dao.CustomerRepo;
import com.shopping4th.ecommerce.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Override
	public List<Customer> findAll() {
		return this.customerRepo.findAll();
	}

	@Override
	public Customer findById(Long id) {
		Optional<Customer> customer = this.customerRepo.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			throw new EntityNotFoundException("Customer with id " + id +" not found");
		}
	}

	@Override
	public void save(Customer customer) {
		this.customerRepo.save(customer);
	}

	@Override
	public void deletedById(Long id) {
		this.customerRepo.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return this.customerRepo.existsById(id);
	}


}
