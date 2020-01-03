package com.shopping4th.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.shopping4th.ecommerce.entity.Orders;
import com.shopping4th.ecommerce.entity.Product;



public interface OrderService {
	public List<Orders> findAll(Pageable pageable);
	public void save(Orders order);
	public Orders findById(Long id);
	public void deletedById(Long id);
	public boolean existsById(Long id);
}
