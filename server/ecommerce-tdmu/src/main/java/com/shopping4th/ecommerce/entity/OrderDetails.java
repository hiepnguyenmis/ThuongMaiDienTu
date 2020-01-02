package com.shopping4th.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
    private Product products;
	
	@Column(name="unit_price")
	private float unitPrice;
	
	@Column(name="quantity")
	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderDetails() {
		super();
	}

	public OrderDetails(Long id, Product products, float unitPrice, int quantity) {
		super();
		this.id = id;
		this.products = products;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public OrderDetails(Product products, float unitPrice, int quantity) {
		super();
		this.products = products;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	
	
	
}
