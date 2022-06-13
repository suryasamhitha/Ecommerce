package com.furniture.service;

import java.util.List;

import com.furniture.bean.CustomerSell;

public interface ICustomerSellService {

		CustomerSell addSellProduct(CustomerSell customerSell);
		
		List<CustomerSell> viewAllProducts();

		CustomerSell deleteProduct(long id);

		CustomerSell updateProduct(CustomerSell product);
		
		CustomerSell getSellProductById(long id);

	}

