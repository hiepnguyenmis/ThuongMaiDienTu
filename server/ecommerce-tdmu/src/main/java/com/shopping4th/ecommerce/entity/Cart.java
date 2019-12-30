package com.shopping4th.ecommerce.entity;

import java.util.List;

public class Cart {

	private List<CartItems> items;

	public Cart(List<CartItems> items) {
		super();
		this.items = items;
	}

	public List<CartItems> getItems() {
		return items;
	}

	public void setItems(List<CartItems> items) {
		this.items = items;
	}
	
}
