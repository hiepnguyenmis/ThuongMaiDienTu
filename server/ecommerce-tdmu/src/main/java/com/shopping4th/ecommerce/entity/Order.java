package com.shopping4th.ecommerce.entity;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	private Accounts accounts;
	
	@Column(name="is_paid")
	private String isPaid;
	
	@Column(name="order_status")
	private String orderStatus;
	
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
	
	@Column(name="notes")
	private String notes;

//	@Column(name="discount_rate")
//	private int discountRate;
	
	//voucher_id
	
	@OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    
    @JoinColumn(name = "order_id")
    private List<OrderDetails> orderDetails;
	
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

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
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

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Order() {
		super();
	}

	public Order(Accounts accounts, String isPaid, String orderStatus, Date deliveriedDate, String name, String address,
			String phone, List<OrderDetails> orderDetails, String notes) {
		super();
		this.accounts = accounts;
		this.isPaid = isPaid;
		this.orderStatus = orderStatus;
		this.deliveriedDate = deliveriedDate;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.orderDetails = orderDetails;
		this.notes=notes;
	}

	
}
