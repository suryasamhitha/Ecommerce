class CartItem {
  constructor(cartId, quantity, productId, phoneNo, email, customerLoginId, date, address) {

     		this.cartId = cartId;
			this.quantity = quantity;
			this.productId = productId;
			this.phoneNo = phoneNo;
			this.email = email;
			this.customerLoginId = customerLoginId;
			this.date = date;
			this.address = address;

  }
}

export default CartItem;
