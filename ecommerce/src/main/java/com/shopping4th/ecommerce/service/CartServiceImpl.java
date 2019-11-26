package com.shopping4th.ecommerce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping4th.ecommerce.dao.CartRepo;
import com.shopping4th.ecommerce.dao.ProductRepo;
import com.shopping4th.ecommerce.entity.Accounts;
import com.shopping4th.ecommerce.entity.CartDto;
import com.shopping4th.ecommerce.entity.Carts;
import com.shopping4th.ecommerce.entity.Product;
import com.shopping4th.ecommerce.utilities.CartStatus;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Carts> findAll() {
		//return this.cartRepo.findAll();
		
		return this.cartRepo.findByStatus(CartStatus.NOT_PURCHASED.toString());
	}

	@Override
	public Carts findById(Long id) {
		Optional<Carts> cart = this.cartRepo.findById(id);
		if(!cart.isPresent()) {
			throw new EntityNotFoundException("Not found cart with id: "+ id);
		}
		return cart.get();
	}

	@Override
	public void save(Carts carts) {
		
		this.cartRepo.save(carts);
	}

	@Override
	public void deletedById(Long id) {
		this.cartRepo.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return this.cartRepo.existsById(id);
	}

	@Override
	public void deleteAll(Long accountId) {
		boolean isAccount = this.cartRepo.existsByAccountId(accountId);
		if(isAccount) {
			this.cartRepo.deleteAll(this.cartRepo.findByAccountId(accountId));
		}
		else throw new EntityNotFoundException("Empty cart with account id "+accountId);
		
	}

	@Override
	public Carts findByAccountIdAndProductId(Long accountId, Long productId) {
		return this.cartRepo.findByAccountIdAndProductId(accountId, productId);
	}

	

}
