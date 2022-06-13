package com.furniture.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	//POJO class for Product 
		@Entity
		@Table(name="product")
		public class Product {
				
				@Id
				@GeneratedValue(strategy=GenerationType.SEQUENCE)
				private long productId;
				@Column(unique = true)
				private String name;
				private String color;
				private double price;
				private String description;
				private int quantity;
				private String category;
				private String imgUrl;
				
				public Product() {}
				
				public Product(long productId, String name,String color, double price, String description, int quantity, String category, String imgUrl) {
					super();
					this.name = name;
					this.color = color;
					this.price = price;
					this.description = description;
					this.quantity = quantity;
					this.category = category;
					this.imgUrl = imgUrl;
				}
				
				public long getProductId() {
					return productId;
				}
				public void setProductId(long productId) {
					this.productId = productId;
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

				@Override
				public String toString() {
					return "Product [productId=" + productId + ", name=" + name + ", color=" + color +  ", price=" + price + ", description="
							+ description + ", quantity=" + quantity + ", Category=" + category + "]";
				}

				
			}
