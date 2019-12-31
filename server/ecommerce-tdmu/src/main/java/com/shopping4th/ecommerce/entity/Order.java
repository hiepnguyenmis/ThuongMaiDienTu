package com.shopping4th.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order")
public class Order {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	private Accounts accounts;
	
	@Column(name="is_paid")
	private boolean isPaid;
	
	@Column(name="order_status")
	private boolean orderStatus;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deliveried_date", updatable=true)
	private Date deliveriedDate;
	
	@Column(name="customer_name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;

//	@Column(name="discount_rate")
//	private int discountRate;
	
	//voucher_id
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDeliveriedDate() {
		return deliveriedDate;
	}

	public void setDeliveriedDate(Date deliveriedDate) {
		this.deliveriedDate = deliveriedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Order() {
		super();
	}

	public Order(Long id, Accounts accounts, boolean isPaid, boolean orderStatus, Date createdAt, Date deliveriedDate,
			String name, String address, String phone) {
		super();
		this.id = id;
		this.accounts = accounts;
		this.isPaid = isPaid;
		this.orderStatus = orderStatus;
		this.createdAt = createdAt;
		this.deliveriedDate = deliveriedDate;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Order(Accounts accounts, boolean isPaid, boolean orderStatus, Date createdAt, Date deliveriedDate,
			String name, String address, String phone) {
		super();
		this.accounts = accounts;
		this.isPaid = isPaid;
		this.orderStatus = orderStatus;
		this.createdAt = createdAt;
		this.deliveriedDate = deliveriedDate;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Order(Date deliveriedDate) {
		super();
		this.deliveriedDate = deliveriedDate;
	}

	
}
