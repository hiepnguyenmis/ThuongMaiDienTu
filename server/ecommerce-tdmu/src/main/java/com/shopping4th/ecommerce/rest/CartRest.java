package com.shopping4th.ecommerce.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping4th.ecommerce.entity.Accounts;
import com.shopping4th.ecommerce.entity.Cart;
import com.shopping4th.ecommerce.entity.CartItems;
import com.shopping4th.ecommerce.entity.Product;
import com.shopping4th.ecommerce.service.AccountService;
import com.shopping4th.ecommerce.service.CartService;
import com.shopping4th.ecommerce.utilities.CartStatus;

import ch.qos.logback.core.net.SyslogOutputStream;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class CartRest {

	public static final Logger logger = LoggerFactory.getLogger(CartRest.class);
	
	@Autowired
	private CartService cartService;
	
//	public CartRest(CartService cartService) {
//		this.cartService = cartService;
//	}
	
	@Autowired
	private AccountService accountService;


	@GetMapping(value = "/accounts/{accountId}/carts")
	public List<CartItems> getCartByAccount(@PathVariable Long accountId) {
		logger.info("Fetching with cart for account id {}", accountId);
		boolean isCart = this.accountService.existsById(accountId);
		if(!isCart) {
			logger.error("Cart with id {} not found.", accountId);
			throw new RuntimeException("Cart "+ accountId + " is not found");
		}
		
		return this.cartService.findCartByAccount(accountId);
	}
	
	
	@DeleteMapping(value="/carts/{id}")
	public void removeCartItem(@PathVariable Long id) {
		boolean isCartItem = this.cartService.existsById(id);
		if(!isCartItem) {
			logger.error("Cart with id {} not found.", id);
			throw new RuntimeException("Cart item "+ id + " is not found");
		}
		
		this.cartService.deletedById(id);
	}
	
	@DeleteMapping(value="/accounts/{accountId}/carts")
	public void removeCart(@PathVariable Long accountId) {
		Accounts acc = this.accountService.findById(accountId);
		if(!acc.equals(null)) {
			this.cartService.deleteAll(accountId);
			logger.info("Deleted cart accountId {} successfully", accountId);
			
		}
		logger.error("Failed for deleting cart accountId {}", accountId);
	
	}
	
//	@PostMapping(value = "/carts")
//	public ResponseEntity<CartItems> addItem(@Valid @RequestBody CartItems carts) {
//		CartItems existsCart = this.cartService.findByAccountIdAndProductId(carts.getAccount().getId(), carts.getProduct().getId());
//		if(!existsCart.equals(null)) {
//			
//			existsCart.setQuantity(carts.getQuantity()+existsCart.getQuantity());
//			
//			this.cartService.save(existsCart);
//			return ResponseEntity.status(HttpStatus.OK).build();
//			//return this.cartService.findById(existsCart.getId());
//		}
//		else {
//			carts.setStatus(CartStatus.NOT_PURCHASED.toString());
//			this.cartService.save(carts);
//			return ResponseEntity.status(HttpStatus.OK).build();
//			//return this.cartService.findById(carts.getId());
//		}
//
//	}
	
	@PostMapping(value="/accounts/{accountId}/carts")
	public ResponseEntity<CartItems> addToCart(@Valid @RequestBody CartItems item, @PathVariable Long accountId){
		Accounts acc = this.accountService.findById(accountId);
		Product p = item.getProduct();
		boolean isItem = this.cartService.existsByAccountIdAndProductIdAndStatus(accountId, p.getId(), CartStatus.NOT_PURCHASED.toString());
		//CartItems existsCart = this.cartService.findByAccountIdAndProductId(accountId, p.getId());
		if(isItem) {
			CartItems existsCart = this.cartService.findByAccountIdAndProductIdAndStatus(accountId, p.getId(), CartStatus.NOT_PURCHASED.toString());
			int quantity = existsCart.getQuantity()+1;
			existsCart.setQuantity(quantity);
			//existsCart.setAccount(acc);
			this.cartService.save(existsCart);
			return ResponseEntity.status(HttpStatus.OK).build();
			//return this.cartService.findById(existsCart.getId());
		}
		else {
			item.setStatus(CartStatus.NOT_PURCHASED.toString());
			item.setAccount(acc);
			item.setProduct(p);
			item.setQuantity(1);
			this.cartService.save(item);
			return ResponseEntity.status(HttpStatus.OK).build();
			//return this.cartService.findById(item.getId());
		}
	}
	
	@GetMapping("/accounts/{accountId}/subtotal")
	public Cart GetSubTotal(@PathVariable Long accountId) {
		Double subTotal=0.0;
		List<CartItems> carts = this.cartService.findCartByAccount(accountId);
		
		if(!carts.equals(null)) {
			for(CartItems item: carts) {
				subTotal+=item.getQuantity()*Double.parseDouble(item.getProduct().getPrice());
			}
		}
		Cart cart = new Cart();
		cart.setItems(carts);
		cart.setSubTotal();
		
		return cart;
	}
	
	@PutMapping(value="/carts/{id}")
	public ResponseEntity<CartItems> updateCart(@PathVariable Long id,@Valid @RequestBody CartItems carts) {
		CartItems existsCart = this.cartService.findById(id);
		if(!existsCart.equals(null)) {
			
			existsCart.setQuantity(carts.getQuantity());
			existsCart.setId(id);
			this.cartService.save(existsCart);
			return ResponseEntity.status(HttpStatus.OK).build();
			//return this.cartService.findById(existsCart.getId());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
