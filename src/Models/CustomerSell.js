class CustomerSell {
  constructor(sellId,name, color, price, description,quantity , category,imageUrl, status, customer, address ) {
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
}

export default CustomerSell;
