package com.furniture.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.bean.CustomerSell;
import com.furniture.bean.Payment;
import com.furniture.bean.Product;
import com.furniture.bean.TransactionHistory;
import com.furniture.service.CartItemServiceImpl;
import com.furniture.service.CustomerSellServiceImpl;
import com.furniture.service.PaymentServiceImpl;
import com.furniture.service.ProductServiceImpl;
import com.furniture.service.TransactionServiceImpl;
import com.furniture.service.UserServiceImpl;
import com.furniture.bean.User;

@RestController
@RequestMapping("/AdminController")
//@CrossOrigin(origins = "http://frontendfurniture1.s3-website.us-east-2.amazonaws.com")
@CrossOrigin(origins = "*")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private CustomerSellServiceImpl customerSellService;

	@Autowired
	private ProductServiceImpl productService;

	@Autowired
	private PaymentServiceImpl paymentService;

	@Autowired
	CartItemServiceImpl cartService;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	TransactionServiceImpl transactionService;

//Admin
	//updates info for given user
		@PutMapping(path="/user/update")
		public ResponseEntity<User> updateUser(@RequestBody User user)
		{
			logger.info("updateUser method of AdminController called", System.currentTimeMillis());
			User updatedUser=userService.updateUser(user);
			
			logger.info("user info for user "+user.getLoginId()+"updated successfully",System.currentTimeMillis());
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		}
	
	
//PRODUCT

	// add products
	@PostMapping(path = "/product/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product inputProduct) {
		logger.info("addProduct method of AdminController called", System.currentTimeMillis());
		Product product = productService.addProduct(inputProduct);

		logger.info("product with id " + product.getProductId() + " added successfully", System.currentTimeMillis());
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	// updates info for given product
	@PutMapping(path = "/product/update/{product}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Product> updateProduct(@PathVariable Product product) {
		logger.info("updateProduct method of AdminController called");
		Product updatedProduct = productService.updateProduct(product);

		logger.info("product with id " + product.getProductId() + " updated successfully");
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}

	// deletes product info for given productId
	@DeleteMapping(path = "/product/delete/{productId}", produces = "application/json")
	public ResponseEntity<String> deleteProduct(@PathVariable long productId) {
		logger.info("deleteProduct method of AdminController called", System.currentTimeMillis());
		productService.deleteProduct(productId);

		logger.info("product with id " + productId + " deleted successfully", System.currentTimeMillis());
		return new ResponseEntity<>("Product is deleted", HttpStatus.OK);
	}

	// view product info for given productId
	@GetMapping(path = "/product/view-id/{productId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Product> getProductById(@PathVariable long productId) {
		logger.info("getProductById method of AdminController called", System.currentTimeMillis());
		Product product = productService.viewProductById(productId);

		logger.info("product with id " + productId + " found successfully", System.currentTimeMillis());
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	// returns product info for given productName
	@GetMapping(path = "/product/view-name/{name}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Product> getProductByName(@PathVariable String name) {
		logger.info("getProductByName method of AdminController called", System.currentTimeMillis());
		Product product = productService.viewProductByName(name);

		logger.info("product with name " + " name" + "found successfully");
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	// returns list of available products in the given category
	@GetMapping(path = "/product/view-category/{category}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
		logger.info("getProductByCategory method of AdminController called", System.currentTimeMillis());
		List<Product> productList = productService.viewProductsByCategory(category);

		logger.info(productList.size() + " product(s) of category " + category + " found", System.currentTimeMillis());
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}


//TRANSACTION HISTORY

	// returns order history of all users
	@GetMapping(path = "/allhistory", produces = "application/json")
	public ResponseEntity<List<TransactionHistory>> viewAllTransaction() {
		logger.info("viewAllBookingHistory method of AdminController called", System.currentTimeMillis());
		List<TransactionHistory> history = transactionService.viewAllTransaction();

		logger.info("booking history of all users found with " + history.size() + " record(s)",
				System.currentTimeMillis());
		return new ResponseEntity<>(history, HttpStatus.OK);
	}
	// updates info for given transaction
		@PutMapping(path = "/transaction/update", consumes = "application/json", produces = "application/json")
		public ResponseEntity<TransactionHistory> updateStatus(@RequestBody long trId,TransactionHistory history) {
			logger.info("updateProduct method of AdminController called");
			TransactionHistory updateStatus = transactionService.updateStatus(trId, history);

			logger.info("product with id " + history.getTrId() + " updated successfully");
			return new ResponseEntity<>(updateStatus, HttpStatus.OK);
		}

//PAYMENT DETAILS

	// view all payment details
	@GetMapping(path = "/allPayments", consumes = "application/json", produces = "application/json")
	public Iterable<Payment> getAllPayments() {
		logger.info("Entered inside get all method of payment controller");
		return paymentService.getAllPayments();
	}

//CUSTOMER'S PRODUCT STATUS
	@PutMapping(path = "customer/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerSell> updateProduct(@RequestBody CustomerSell customerSell) {
		logger.info("updateProduct method of AdminController called");
		CustomerSell updatedProduct = customerSellService.updateProduct(customerSell);

		logger.info("product with id " + customerSell.getSellId() + " updated successfully");
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	// view product info for given productId
		@GetMapping(path = "/sell/view-id/{sellId}", consumes = "application/json", produces = "application/json")
		public ResponseEntity<CustomerSell> getSellProductById(@PathVariable long sellId) {
			logger.info("getSellProductById method of AdminController called", System.currentTimeMillis());
			CustomerSell product = customerSellService.getSellProductById(sellId);

			logger.info("product with id " + sellId + " found successfully", System.currentTimeMillis());
			return new ResponseEntity<>(product, HttpStatus.OK);
		}


}

/*
 * //returns order history of user with given loginId
 * 
 * @GetMapping(path="/customer/order-history/{orderId}",
 * produces="application/json") public ResponseEntity<List<CartItem>>
 * viewOrderHistoryById(@PathVariable String orderId) {
 * logger.info("viewBookingHistory method of AdminController called",System.
 * currentTimeMillis()); List<CartItem>
 * orderHistory=cartService.viewAllOrderHistory(orderId);
 * 
 * logger.info("booking history for user " +orderId + " found with "+
 * orderHistory.size() +" record(s)",System.currentTimeMillis()); return new
 * ResponseEntity<>(orderHistory, HttpStatus.OK); }
 */
