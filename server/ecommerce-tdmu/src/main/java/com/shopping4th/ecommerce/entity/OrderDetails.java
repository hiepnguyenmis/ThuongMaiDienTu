package com.shopping4th.ecommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {

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
	
	
	
	
	
	
}
