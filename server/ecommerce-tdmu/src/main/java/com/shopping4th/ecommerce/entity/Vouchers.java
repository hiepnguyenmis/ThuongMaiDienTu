package com.shopping4th.ecommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.JoinColumn;

@Entity
@Table(name="vouchers")

public class Vouchers {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="voucher_code")
	private String voucherCode;
	
	@Column(name="discount_rate")
	private double discountRate;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
			  name = "product_voucher", 
			  joinColumns = @JoinColumn(name = "voucher_id"), 
			  inverseJoinColumns = @JoinColumn(name = "product_id"))
	Set<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Vouchers() {
		super();
	}

	
	public Vouchers(String voucherCode, double discountRate, Set<Product> products) {
		super();
		this.voucherCode = voucherCode;
		this.discountRate = discountRate;
		this.products = products;
	}

	public Vouchers(Long id, String voucherCode, double discountRate) {
		super();
		this.id = id;
		this.voucherCode = voucherCode;
		this.discountRate = discountRate;
	}
	
	
	
	
}
