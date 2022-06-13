package com.furniture.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sell_request")

public class CustomerSell {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long sellId;	
	private String name;
	private String color;
	private double price;
	private String description;
	private int quantity;
	private String category;
	private String imgUrl;
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loginId")
	private User customer;
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;
	
	public CustomerSell() {}

	public CustomerSell(long sellId, String name, String color, double price, String description, int quantity,
			String category, String imgUrl, String status, User customer, Address address) {
		super();
		this.sellId = sellId;
		this.name = name;
		this.color = color;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.imgUrl = imgUrl;
		this.status = status;
		this.customer = customer;
		this.address = address;
	}

	public long getSellId() {
		return sellId;
	}

	public void setSellId(long sellId) {
		this.sellId = sellId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerSell [sellId=" + sellId + ", name=" + name + ", color=" + color + ", price=" + price
				+ ", description=" + description + ", quantity=" + quantity + ", category=" + category + ", imgUrl="
				+ imgUrl + ", status=" + status + ", customer=" + customer + ", address=" + address + "]";
	}
	
	
}

