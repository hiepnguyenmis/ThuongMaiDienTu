package com.shopping4th.ecommerce.rest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Accounts;
import com.shopping4th.ecommerce.entity.Customer;
import com.shopping4th.ecommerce.service.CustomerService;
import com.shopping4th.ecommerce.service.IAccountService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class CustomerRest {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private IAccountService accountService;
	
	@GetMapping(value="/customers")
	public List<Customer> getAllCustomers(){
		return this.customerService.findAll();
	}
	
	@GetMapping(value="/customers/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return this.customerService.findById(id);
	}
	
	@GetMapping(value = "/users")
	public Accounts getCustomerByUserEmail(@RequestParam String email) {
		
		return this.accountService.findByEmail(email);
	}
	
	@DeleteMapping(value="/customers/{id}")
	public void deleteById(@PathVariable Long id) {
		this.customerService.deletedById(id);
	}
	
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		if(!customerService.existsById(id)) {
			throw new EntityNotFoundException("Customer "+ id + " is not found");
		}
		
		customer.setId(id);
		customerService.save(customer);
		return this.customerService.findById(id);
	}
	
	@PostMapping(value ="/customers")
	public Customer createCategory(@Valid @RequestBody Customer customer) {
		
		customerService.save(customer);
		return customerService.findById(customer.getId());
	}
	
}
