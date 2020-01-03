package com.shopping4th.ecommerce.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Orders;
import com.shopping4th.ecommerce.entity.Product;
import com.shopping4th.ecommerce.service.OrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderRest {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders(Pageable pageable){
		return this.orderService.findAll(pageable);
	} 
	
	@GetMapping(value="orders/{id}")
	public Orders getProduct(@PathVariable Long id) {
		boolean isOrder = this.orderService.existsById(id);
		if(!isOrder) {                                       
			throw new RuntimeException("Order "+ id + " is not found");
		}
		
		return orderService.findById(id);
	}
}
