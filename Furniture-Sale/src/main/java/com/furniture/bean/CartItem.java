package com.furniture.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartItem  {
		
		@Id
		@Column(name="cart_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int cartId;
		private long qty;
		//mapping
		@OneToMany
		@Column(name="product")
		Set<Product> product;
		@OneToOne
		@JoinColumn(name="loginId")
		private User customerLoginId;
		private Date date;

		public CartItem() {}

		public CartItem(int cartId, long qty, Set<Product> product, User customerLoginId, Date date) {
			super();
			this.cartId = cartId;
			this.qty = qty;
			this.product = product;
			this.customerLoginId = customerLoginId;
			this.date = date;
		}

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public long getQty() {
			return qty;
		}

		public void setQty(long qty) {
			this.qty = qty;
		}

		public Set<Product> getProduct() {
			return product;
		}

		public void setProduct(Set<Product> product) {
			this.product = product;
		}

		public User getCustomerLoginId() {
			return customerLoginId;
		}

		public void setCustomerLoginId(User customerLoginId) {
			this.customerLoginId = customerLoginId;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "CartItem [cartId=" + cartId + ", qty=" + qty + ", product=" + product + ", customerLoginId="
					+ customerLoginId + ", date=" + date + "]";
		}
		
}
