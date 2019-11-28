package com.shopping4th.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping4th.ecommerce.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	//public Customer findByAccountsId(Long accountId);
}
