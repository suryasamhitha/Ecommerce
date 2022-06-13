package com.furniture.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.bean.CartItem;
import com.furniture.bean.CustomerSell;
import com.furniture.bean.Payment;
import com.furniture.bean.Product;
import com.furniture.bean.TransactionHistory;
import com.furniture.bean.User;
import com.furniture.exception.PaymentException;
import com.furniture.service.CartItemServiceImpl;
import com.furniture.service.CustomerSellServiceImpl;
import com.furniture.service.UserServiceImpl;
import com.furniture.service.MapValidationErrorService;
import com.furniture.service.PaymentServiceImpl;
import com.furniture.service.ProductServiceImpl;
import com.furniture.service.TransactionServiceImpl;

@RestController
@RequestMapping("/CustomerController")
//@CrossOrigin(origins = "http://frontendfurniture1.s3-website.us-east-2.amazonaws.com")
@CrossOrigin(origins = "*")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private PaymentServiceImpl paymentService;

	@Autowired
	private ProductServiceImpl productService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@Autowired
	private CustomerSellServiceImpl customerSellService;

	@Autowired
	private CartItemServiceImpl cartService;
	
	@Autowired
	private TransactionServiceImpl transactionService;	
	
	@Autowired
	private UserServiceImpl userService;

//CUSTOMER	
	
	//updates details for a specific user
		@PutMapping(path="/user/update")
		public ResponseEntity<User> updateUser(@RequestBody User inputUser)
		{
			logger.info("updateUser method of CustomerController called", System.currentTimeMillis());
			User user=userService.updateUser(inputUser);
			
			logger.info("user "+user.getLoginId()+"updated successfully",System.currentTimeMillis());
			return new ResponseEntity<>(user, HttpStatus.OK);

		}
		
		//returns user info for given userId
		@GetMapping(path="/user/{userId}")	
		public ResponseEntity<User> getUserById(@PathVariable long userId)
		{
			logger.info("getUserById method of CustomerController called",System.currentTimeMillis());
			User user=userService.findById(userId);
			
			logger.info("user with id "+userId+" found successfully",System.currentTimeMillis());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
			
		//returns user info for given loginId
		@GetMapping(path="/user/login-id/{loginId}")	
		public ResponseEntity<User> getUserByLoginId(@PathVariable String loginId)
		{
			logger.info("getUserByLogin method of CustomerController called", System.currentTimeMillis());
			User user=userService.findByLoginId(loginId);
			
			logger.info("user with login id "+loginId+" found",System.currentTimeMillis());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}

//PRODUCT	
	// returns list of all available products
	@GetMapping(path = "/product/view-all")
	public ResponseEntity<List<Product>> AllProducts() {
		logger.info("getAllProducts method of AdminController called", System.currentTimeMillis());
		List<Product> productList = productService.AllProducts();

		logger.info(productList.size() + "product(s) found", System.currentTimeMillis());
		return new ResponseEntity<>(productList, HttpStatus.OK);

	}
	
//Transaction History		
	// returns product info for given productId
	@GetMapping(path = "/history/{trId}")
	public ResponseEntity<TransactionHistory> viewTransactions(@PathVariable long trId) {
		logger.info("getProductById method of CustomerController called", System.currentTimeMillis());
		TransactionHistory history = transactionService.viewTransactions(trId);

		logger.info("list for " + trId + " found", System.currentTimeMillis());
		return new ResponseEntity<>(history, HttpStatus.OK);
	}

//CART ITEMS
	// add products to cart
	@PostMapping(path = "/cart")

	public CartItem addCart(@RequestBody CartItem cart) {
		logger.info("Cart addCart()");
		return cartService.addCart(cart);
	}

	// delete products from cart
	@DeleteMapping(path = "/delete{cartId}")
	public CartItem removeCart(@PathVariable("cartId") int cartId) {
		logger.info("Cart removeCart()");
		return cartService.removeCart(cartId);
	}

	// views cart products
	@GetMapping(path = "/cart/{loginId}")
	public CartItem viewAllCustomer(@PathVariable("loginId") long loginId) {
		logger.info("Cart viewCustomer()");
		return cartService.viewCustomer(loginId);
	}

//PAYEMNT
	// add payment details
	@PostMapping(path = "/payment/add")
	public ResponseEntity<?> addPayment(@RequestBody Payment payment, BindingResult result) {
		logger.info("Entered inside add method of payment controller");
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null) {
			return errorMap;
		}
		Payment newPayment = paymentService.addPayment(payment);

		return new ResponseEntity<>(newPayment, HttpStatus.CREATED);

	}
	// delete payment details
	@DeleteMapping(path = "/payment/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable int paymentId) throws PaymentException {
		logger.info("Entered inside delete method of payment controller");
		paymentService.deletePayment(paymentId);
		return new ResponseEntity<>("Payment with Id : " + paymentId + " id deleted.....", HttpStatus.OK);

	}

	// view payment details by id
	@GetMapping(path = "/payment-view/{paymentId}")
	public ResponseEntity<Payment> viewPaymentById(@PathVariable int paymentId) throws PaymentException {
		logger.info("Entered inside get method of payment controller");
		return new ResponseEntity<>(paymentService.viewPaymentDetailsById(paymentId), HttpStatus.OK);

	}

	// view all payment details
	@GetMapping(path = "/allPayments")
	public Iterable<Payment> getAllPayments() {
		logger.info("Entered inside get all method of payment controller");
		return paymentService.getAllPayments();
	}

//CUSTOMER SELL
	// customer Sell product
	@PostMapping(path = "/customer/sell")

	public ResponseEntity<CustomerSell> sellproduct(@RequestBody CustomerSell customerSell) {

		logger.info("addProduct method of AdminController called", System.currentTimeMillis());
		CustomerSell sell = customerSellService.addSellProduct(customerSell);

		logger.info("product with id " + sell.getSellId() + " added successfully", System.currentTimeMillis());
		return new ResponseEntity<>(sell, HttpStatus.OK);
	}
	// delete product by product ID
	@DeleteMapping(path = "customer/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable long productId) {
		logger.info("deleteProduct method of AdminController called", System.currentTimeMillis());
		customerSellService.deleteProduct(productId);

		logger.info("product with id " + productId + " deleted successfully", System.currentTimeMillis());
		return new ResponseEntity<>("Product is deleted", HttpStatus.OK);
	}
	
	// returns list of all available products
		@GetMapping(path = "/sell/view")
		public ResponseEntity<List<CustomerSell>> viewAllProducts() {
			logger.info("viewProducts method of CustomerController called", System.currentTimeMillis());
			List<CustomerSell> sell = customerSellService.viewAllProducts();

			logger.info(sell.size() + "product(s) found", System.currentTimeMillis());
			return new ResponseEntity<>(sell, HttpStatus.OK);

		}

}
