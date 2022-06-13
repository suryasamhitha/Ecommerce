class ProductOrder {
  constructor(
    trId,
    delStatus,
    customer,
    payment,
    cartItem,
    address,
    date
  ) {
    this.trId = trId;
		this.delStatus = delStatus;
		this.customer = customer;
		this.payment = payment;
		this.cartItem = cartItem;
		this.address = address;
		this.date = date;
  }
}

export default ProductOrder;
