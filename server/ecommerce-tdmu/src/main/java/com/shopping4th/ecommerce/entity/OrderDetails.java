package com.shopping4th.ecommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "order_items", joinColumns = {
            @JoinColumn(name = "order_details_id") }, inverseJoinColumns = {
            @JoinColumn(name = "product_id") })
    private Set<Product> products;
	
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
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

	public OrderDetails(Set<Product> products, float unitPrice, int quantity) {
		super();
		this.products = products;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public OrderDetails(Long id, Set<Product> products, float unitPrice, int quantity) {
		super();
		this.id = id;
		this.products = products;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	
}
