package com.shopping4th.ecommerce.rest;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Orders getOrder(@PathVariable Long id) {
		boolean isOrder = this.orderService.existsById(id);
		if(!isOrder) {                                       
			throw new RuntimeException("Order "+ id + " is not found");
		}
		
		return orderService.findById(id);
	}
	
	@DeleteMapping(value="orders/{id}")
	public void deleteOrder(@PathVariable Long id) {
		boolean isOrder = this.orderService.existsById(id);
		if(!isOrder) {
			throw new RuntimeException("Product "+ id + " is not found");
		}
		
		orderService.deletedById(id);
		
	}
	
	@PostMapping(value="/orders")
	public Orders createOrder(@Valid @RequestBody Orders order) {
		order.setCreatedAt(new Date());
		orderService.save(order);
		return orderService.findById(order.getId());
	}
}
