package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping4th.ecommerce.dao.OrderRepo;
import com.shopping4th.ecommerce.entity.Orders;
import com.shopping4th.ecommerce.entity.Product;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;

	@Override
	public List<Orders> findAll(Pageable pageable) {
		Page<Orders> order=this.orderRepo.findAll(pageable);
		return order.getContent();
	}

	@Override
	public void save(Orders order) {
		this.orderRepo.save(order);
	}

	@Override
	public Orders findById(Long id) {
		Optional<Orders> order = this.orderRepo.findById(id);
		if(order.isPresent()) {
			return order.get();
		
		}
		else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public void deletedById(Long id) {
		this.orderRepo.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return this.orderRepo.existsById(id);
	}

}
