package com.furniture.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.bean.User;
import com.furniture.service.UserServiceImpl;
import com.furniture.service.LoginServiceImpl;
@RestController
@RequestMapping("/LoginController")
//@CrossOrigin(origins = "http://frontendfurniture1.s3-website.us-east-2.amazonaws.com")
@CrossOrigin(origins = "*")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginServiceImpl loginService;
    
    @Autowired
    private UserServiceImpl userService;
   
    //Persist user info to database
  	@PostMapping(path = "/register")
  	public ResponseEntity<User> addUser(@RequestBody User user)
  	{
  		logger.info("addUser method of main controller called", System.currentTimeMillis());
  		User addedUser=userService.addUser(user);
  		
  		logger.info("new user registered ",user.toString());
  		return new ResponseEntity<User>(addedUser, HttpStatus.OK);
  	}
  	
  //Updates password if oldPassword matches the loginId
  	@PutMapping(path="/change-password/{loginId}/{oldPassword}/{newPassword}")
  	public ResponseEntity<String> changePassword(@PathVariable String loginId, @PathVariable String oldPassword, @PathVariable String newPassword)
  	{
  	logger.info("changePassword method of MainController called", System.currentTimeMillis());
  	userService.changePassword(loginId, oldPassword, newPassword);
  	logger.info("Password for userId "+loginId+" changed successfully");
  	return new ResponseEntity<>("Password changed successfully.", HttpStatus.OK);
  	}
  	
 // for the login id is given, password is updated
  	@PutMapping(path="/forgot-password/{loginId}/{newPassword}")
  	public ResponseEntity<String> forgotPassword(@PathVariable String loginId, @PathVariable String newPassword)
  	{
  	userService.forgotPassword(loginId, newPassword);
  	logger.info("Password of user "+loginId+" changed successfully");
  	return new ResponseEntity<>("Password changed successfully.", HttpStatus.OK);

  	 }

  	@GetMapping(path="/login/{loginId}/{password}") 
	public ResponseEntity<User> login(@PathVariable String loginId, @PathVariable String password) 
	{ 
		logger.info("login method of MainController called", System.currentTimeMillis());
		User user=loginService.login(loginId, password);

		logger.info("User"+user.getLoginId()+"logged in successfully", System.currentTimeMillis());
		return new ResponseEntity<>(user, HttpStatus.OK); 
		
	 }
  	
  }













/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.bean.Customer;
import com.furniture.bean.User;
import com.furniture.service.CustomerServiceImpl;
import com.furniture.service.LoginServiceImpl;


@RestController
@RequestMapping("/LoginController")
@CrossOrigin(origins="*")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
//login with Admin details	
	@GetMapping(path="/login" ,consumes="application/json",produces = "application/json")
	public ResponseEntity<User> Login(@RequestBody User user){
		logger.info("getAdmin method of LoginController to Login called");

		logger.info("getAdmin method of LoginController to Login ends");
	
		return new ResponseEntity<>(loginService.Login(user), HttpStatus.ACCEPTED);
	}
	
//Takes user loginId, password, and return corresponding user object
	@GetMapping(path="/login/{loginId}/{password}", produces="application/json") 
	public ResponseEntity<Customer> login(@PathVariable String loginId, @PathVariable String password) 
	{ 
		logger.info("login method of MainController called", System.currentTimeMillis());
		Customer customer=customerService.login(loginId, password);

		logger.info("User"+customer.getLoginId()+"logged in successfully", System.currentTimeMillis());
		return new ResponseEntity<>(customer, HttpStatus.OK); 	
	 }
	
//Updates password if oldPassword matches the loginId
	@PutMapping(path="/change-password/{loginId}", produces="application/json")
	public ResponseEntity<String> changePassword(@PathVariable String loginId, @PathVariable String oldPassword, @PathVariable String newPassword)
	{
		logger.info("changePassword method of MainController called", System.currentTimeMillis());
		customerService.changePassword(loginId, oldPassword, newPassword);
		
		logger.info("Password for userId "+loginId+" changed successfully");
		return new ResponseEntity<>("Password changed successfully.", HttpStatus.OK);
	}
	
	//if the correct answer for the security question for the login id is given, password is updated
	@PutMapping(path="/forgot-password/{loginId}/{answer}/{newPassword}", produces="application/json")
	public ResponseEntity<String> forgotPassword(@PathVariable String loginId, @PathVariable String answer, @PathVariable String newPassword)
	{
		customerService.forgotPassword(loginId, answer);
		
		logger.info("Password of user "+loginId+" changed successfully");
		return new ResponseEntity<>("Password changed successfully.", HttpStatus.OK);

	}
}*/










//Create User
/*
	@PostMapping(path = "/user/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> addUser(@RequestBody Customer inputUser) {
	logger.info("addUser method of CustomerController called ",System.currentTimeMillis());
	Customer newUser = customerService.addUser(inputUser);
	//if(inputUser != null)
	logger.info("customer "+inputUser.getEmail()+"registered successfully",System.currentTimeMillis());
	return new ResponseEntity<>(newUser, HttpStatus.OK);
	//logger.info("postCsutomer method of CustomerController ends", new Date(System.currentTimeMillis()));
	//return new ResponseEntity<>(newUser,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	*/
