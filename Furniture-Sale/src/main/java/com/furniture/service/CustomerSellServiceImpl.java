package com.furniture.service;

import java.util.List;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.bean.CartItem;
import com.furniture.bean.CustomerSell;
import com.furniture.exception.CartNotFoundException;
import com.furniture.exception.EmptyOrderException;
import com.furniture.exception.ProductNotFoundException;
import com.furniture.repository.CustomerSellRepository;

@Service
@Transactional
public class CustomerSellServiceImpl implements ICustomerSellService {

	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	CustomerSellRepository sellRepository;

// VIEW CUSTOMER SOLD PRODUCT	
	@Override
	public List<CustomerSell> viewAllProducts() {
		log.info("Entered viewAllProducts()");
		List<CustomerSell> allProducts = sellRepository.findAll();
		if (allProducts.isEmpty()) {
			throw new EmptyOrderException("No Products Found");
		}
		return allProducts;
	}

// ADD PRODUCT TO SELL	
//	@SuppressWarnings("unused")
	@Override
	public CustomerSell addSellProduct(CustomerSell customerSell) {

		log.info("Entered addProduct()");

		customerSell.setStatus("Pending");
		if (customerSell == null)
			throw new ProductNotFoundException("No Products Found");
		else {
			sellRepository.save(customerSell);

			return customerSell;
		}
	}

// DELETE SELL REQUEST	
	@Override
	public CustomerSell deleteProduct(long id) {
		log.info("removeProduct()");
		Optional<CustomerSell> sell = sellRepository.findById(id);
		if (!sell.isPresent()) {
			throw new ProductNotFoundException("No Products Found");
		} else {
			sellRepository.deleteById(id);
			return sell.get();
		}
	}

// UPDATE SELL REQUEST
	@Override
	public CustomerSell updateProduct(CustomerSell product) {
		log.info("Entered updatedProducts()");
		if (product == null) {
			throw new ProductNotFoundException("No Products Found");
		} else {
			sellRepository.save(product);
			return product;
		}
	}

	@Override
	public CustomerSell getSellProductById(long sellId) {
		log.info("Cart viewCustomer()");
		CustomerSell sell = sellRepository.viewProductById(sellId);
		if (sell == null)
			throw new ProductNotFoundException("No Products Found");
		else
			return sell;
	}

}
