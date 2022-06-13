package com.furniture.service;

import java.util.List;

import com.furniture.bean.Product;

public interface IProductService {
	Product addProduct(Product product);

	Product viewProductById(long id);
	
	Product viewProductByName(String name);
	
	List<Product> AllProducts();
	
	Product deleteProduct(long id);

	Product updateProduct(Product product);
	
	List<Product> viewProductsByCategory(String category);
	
	
}