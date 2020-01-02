package com.shopping4th.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
	
}
