package com.shopping4th.ecommerce.entity;

import java.util.List;

public class Cart {

	private List<CartItems> items;
	private float subTotal=0;
	
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

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal() {
		this.subTotal = Float.valueOf(calculateSubTotal(this.items));
	}
	
	private String calculateSubTotal(List<CartItems> items) {
		for(CartItems item: items) {
			subTotal+=item.getQuantity()*Integer.valueOf(item.getProduct().getPrice());
			
		}
		
		String total= String.valueOf(subTotal);

		return total;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + ", subTotal=" + subTotal + "]";
	}
	
	
	
}
