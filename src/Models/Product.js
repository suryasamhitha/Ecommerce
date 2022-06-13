class Product {
  constructor(
    productId,
    name,
    color,
    price,
    description,
    quantity,
    category,
    imgUrl
  ) {
    this.productId = productId;
    this.name = name;
    this.color = color;
    this.price = price;
    this.description = description;
    this.quantity = quantity;
    this.category = category;
    this.imgUrl = imgUrl;
  }
}

export default Product;
