package com.furniture.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.furniture.bean.Product;
import com.furniture.exception.InvalidDetailsException;

public class ProductValidation {

	Logger logger = LoggerFactory.getLogger(ProductValidation.class);

	//validates product info
	public boolean validateProduct(Product product) {
	
		logger.info("validateProduct of ProductValidation called");

		checkName(product.getName());
		
		checkPrice(product.getPrice());
		
		checkQuantity(product.getQuantity());
		
		checkCategory(product.getCategory());
		
		checkImgUrl(product.getImgUrl());
		
		return true;
	}
	
	public boolean validateUpdatedProduct(Product product) {
		
		checkPrice(product.getPrice());
		checkQuantity(product.getQuantity());
		return true;
	}
	
	//checks if image url is null
	private void checkImgUrl(String imgUrl) {
		if(imgUrl==null) {
			logger.error("invalid image url "+imgUrl, System.currentTimeMillis());
			throw new InvalidDetailsException("Image URL is required");
		}
	}
	
	//checks if product name is null
	private void checkName(String name) {
		if(name==null) {
			logger.error("invalid product name "+name, System.currentTimeMillis());
			throw new InvalidDetailsException("Product name cannot be null");
		}
	}
	
	//product price should be greater than 0
	private void checkPrice(double price) {
		if(price<0D) {
			logger.error("invalid product price "+price, System.currentTimeMillis());
			throw new InvalidDetailsException("Product price must be greater than 0");
		}
	}
	
	//product stock should be greater than or equal to 0
	private void checkQuantity(int quantity) {
		if(quantity<=0) {
			logger.error("invalid product quantity "+quantity, System.currentTimeMillis());
			throw new InvalidDetailsException("Product quantity must be greater than 0");
		}
	}
	
	//product should have a category
	private void checkCategory(String category) {
		if(category==null) {
			logger.error("invalid product category "+category);
			throw new InvalidDetailsException("Product must have a category");
		}
	}
	
}