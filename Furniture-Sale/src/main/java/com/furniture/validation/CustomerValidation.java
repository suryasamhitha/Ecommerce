package com.furniture.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.furniture.bean.User;
import com.furniture.exception.InvalidDetailsException;
import com.furniture.exception.InvalidPasswordException;
import com.furniture.exception.UserAlreadyExistsException;
import com.furniture.repository.UserRepository;

@Component
public class CustomerValidation {

	@Autowired
	private UserRepository customerRepo;

	Logger logger = LoggerFactory.getLogger(CustomerValidation.class);

// validates user info before new user is added
	public boolean validateUser(User customer) {

		logger.info("validateUser method of CustomerValidation called", System.currentTimeMillis());
		checkEmail(customer.getEmail());
		checkPhoneNo(customer.getPhoneNo());
		checkName(customer.getFirstName());
		checkName(customer.getLastName());
//		validatePassword(customer.getPassword());
		
		//validate Login Id already exists
		if (customerRepo.findByLoginId(customer.getLoginId()) != null) {
			logger.error("login id already exists", System.currentTimeMillis());
			throw new UserAlreadyExistsException("User already exists for login id " + customer.getLoginId());
		}
		return true;
	}

//validates user info before existing user is updated
	public boolean validateUpdatedUser(User customer) {
		logger.info("validateUpdatedUser method of CustomerValidation called", System.currentTimeMillis());
		
		User val = customerRepo.findByLoginId(customer.getLoginId());
		
		if(customer.getEmail()!= null && val.getEmail()!=customer.getEmail()) {}
		if(customer.getPhoneNo()!= null && val.getPhoneNo()!=customer.getPhoneNo()) {}
		if(customer.getFirstName()!=null && val.getFirstName()!=customer.getFirstName()) {}
		if(customer.getLastName()!= null && val.getLastName()!=customer.getLastName()) {}
		//if (customer.getLoginId() != null && customerRepo.findByLoginId(customer.getLoginId()) == null) {}
		return true;
	}
// validates Admin Login Details
	public boolean validateAdminLogin(User user) {
		logger.info("validateUpdatedUser method of CustomerValidation called", System.currentTimeMillis());
		if (user.getLoginId() != null)
			checkLoginId(user.getLoginId());
//		if (user.getPassword() != null) {}
			//validatePassword(user.getPassword());
		return true;
	}
	// validates customer Login Details
	public boolean validateCustomerLogin(User customer) {
		if (customer.getLoginId()!=null) 
			checkLoginId(customer.getLoginId());
//		if (customer.getPassword()!=null) {}
			//validatePassword(customer.getPassword());
		return true;
}
// checks password 
	public boolean validatePassword(String password) {
		if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}]:;',?/*~$^+=<>]).{8,20}$"))
			return true;
		else {
			logger.error("password does not meet our security standards", System.currentTimeMillis());
			throw new InvalidPasswordException("password does not meet our security standards");
		}
	}
// checks if a Login Id
	private boolean checkLoginId(String loginId) {
		if (!loginId.isEmpty())
			return true;
		else {
			logger.error("login Id validation failed", System.currentTimeMillis());
			throw new InvalidDetailsException("Invalid Login ID");
		}
	}

// checks if a name contains contains only characters
	private boolean checkName(String name) {
		if (!name.isEmpty())
			return true;
		else {
			logger.error("name validation failed", System.currentTimeMillis());
			throw new InvalidDetailsException("Invalid name");
		}
	}
// checks phone number
	private boolean checkPhoneNo(String phoneNo) {
		if (customerRepo.existsByPhoneNo(phoneNo)) {
			throw new UserAlreadyExistsException("Mobile number is already taken by another user");
		}
		if (String.valueOf(phoneNo).length() == 10)
			return true;
		else {
			logger.error("mobile number validation failed", System.currentTimeMillis());
			throw new InvalidDetailsException("Invalid mobile number");
		}
	}

// checks if an emailId meets the required standards
	private boolean checkEmail(String email) {
		if (customerRepo.existsByEmail(email)) {
			throw new UserAlreadyExistsException("Email Id is already taken by another user");
		}
		if (email.matches(
				"^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))
			return true;
		else {
			logger.error("email validation failed for user", System.currentTimeMillis());
			throw new InvalidDetailsException("Invalid email id");
		}
	}
}

// checks if a password meets the required security standards
// length:8-20 characters
// should contain uppercase and lowercase characters
// should contain digits
// should contain !@#&()�[{}]:;',?/*~$^+=<>

// if (customer.getLoginId()!=null &&
// customerRepo.findByLoginId(customer.getLoginId()) != null) {
// logger.info("Login id is already taken", System.currentTimeMillis());
// throw new UserAlreadyExistsException("Login id "+customer.getLoginId() +" is
// not available");
// }