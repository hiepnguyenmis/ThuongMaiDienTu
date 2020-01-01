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
import com.shopping4th.ecommerce.entity.CartItems;
import com.shopping4th.ecommerce.entity.Product;
import com.shopping4th.ecommerce.utilities.CartStatus;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	

	private CartRepo cartRepo;
	private ProductRepo productRepo;

	@Autowired
	public CartServiceImpl(CartRepo cartRepo, ProductRepo productRepo) {
		this.cartRepo = cartRepo;
		this.productRepo = productRepo;
	}

	@Override
	public List<CartItems> findCartByAccount(Long accountId) {
		return this.cartRepo.findByAccountIdAndStatus(accountId, CartStatus.NOT_PURCHASED.toString());
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
	public CartItems findById(Long id) {
		Optional<CartItems> cart = this.cartRepo.findById(id);
		if(!cart.isPresent()) {
			throw new EntityNotFoundException("Not found cart with id: "+ id);
		}
		return cart.get();
	}

	@Override
	public void save(CartItems carts) {
		this.cartRepo.save(carts);
	}

	@Override
	public CartItems findByAccountIdAndProductIdAndStatus(Long accountId, Long productId, String status) {
		return this.cartRepo.findByAccountIdAndProductIdAndStatus(accountId, productId, status);
	}

	@Override
	public boolean existsByAccountIdAndProductIdAndStatus(Long accountId, Long productId, String status) {
		return this.cartRepo.existsByAccountIdAndProductIdAndStatus(accountId, productId, status);
	}

	

}
