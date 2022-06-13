package com.furniture.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "transactions")
public class TransactionHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long trId;
	private String delStatus;
	@OneToOne
	@JoinColumn(name="loginId")
	private User customer;
	@OneToOne
	@JoinColumn(name="payId")
	private Payment payment;
	@OneToOne
	@JoinColumn(name="cartId")
	private CartItem cartItem;
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;
	private Date date;
	public TransactionHistory(long trId, String delStatus, User customer, Payment payment, CartItem cartItem,
			Address address, Date date) {
		super();
		this.trId = trId;
		this.delStatus = delStatus;
		this.customer = customer;
		this.payment = payment;
		this.cartItem = cartItem;
		this.address = address;
		this.date = date;
	}
	public long getTrId() {
		return trId;
	}
	public void setTrId(long trId) {
		this.trId = trId;
	}
	public String getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public CartItem getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TransactionHistory [trId=" + trId + ", delStatus=" + delStatus + ", customer=" + customer + ", payment="
				+ payment + ", cartItem=" + cartItem + ", address=" + address + ", date=" + date + "]";
	}
}
