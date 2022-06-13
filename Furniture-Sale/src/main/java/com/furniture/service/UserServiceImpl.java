package com.furniture.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.bean.AppUser;
import com.furniture.bean.User;
import com.furniture.exception.InvalidPasswordException;
import com.furniture.exception.UserNotFoundException;
import com.furniture.repository.AppUserRepository;
import com.furniture.repository.LoginRepository;
import com.furniture.repository.UserRepository;
//import com.furniture.validation.CustomerValidation;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired 
	private AppUserRepository appUserRepo;
	
	@Autowired
	private LoginRepository loginRepo;
//
//	@Autowired
//	private CustomerValidation customerValidation;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	public AppUser addappUser(AppUser appUser){
		return appUserRepo.save(appUser);
		
	}

	@Override
	public User addUser(User user) {
		logger.info("addUser method of UserServiceImpl called",System.currentTimeMillis());
//		customerValidation.validateUser(user);
//		user.getLogin().setRole("Customer");
//		customerValidation.validateUser(user);
//		user.getAppUser().setRole("Customer");
		
		userRepo.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		logger.info("updateUser method of UserServiceImpl called",System.currentTimeMillis());
		
//		customerValidation.validateUpdatedUser(user);
		
		if(userRepo.existsById(user.getId()))
		{
			User oldUser=userRepo.findById(user.getId()).get();
			
			if(user.getFirstName()!=null)
				oldUser.setFirstName(user.getFirstName());
			
			if(user.getLastName()!=null)
				oldUser.setLastName(user.getLastName());
			
			if(user.getLoginId()!=null)
				oldUser.setLoginId(user.getLoginId());
			
			if(user.getEmail()!=null)
				oldUser.setEmail(user.getEmail());
			
			if(user.getPhoneNo()!=null)
				oldUser.setPhoneNo(user.getPhoneNo());
			
			logger.info("updated details for login id" + user.getLoginId() + "persisted successfully",System.currentTimeMillis());
			return oldUser;
		}
		
		throw new UserNotFoundException("No user found for id "+user.getId());
	}

	@Override
	public User findById(long id) {
	logger.info("findById method of UserServiceImpl called",System.currentTimeMillis());
		
		if(userRepo.existsById(id))
			return userRepo.findById(id).get();
		else
			throw new UserNotFoundException("No user found for id "+id);
	}

	@Override
	public User findByLoginId(String loginId) {
		logger.info("findByLoginId method of UserServiceImpl called",System.currentTimeMillis());
		
		if(userRepo.existsByLoginId(loginId))
			return userRepo.findByLoginId(loginId);
		else
			throw new UserNotFoundException("No user found for login id "+loginId);
	}

	@Override
	public void changePassword(String loginId, String oldPassword, String newPassword) {
	logger.info("changePassword method of UserServiceImpl called",System.currentTimeMillis());
	// customerValidation.validatePassword(newPassword);
	if(userRepo.existsByLoginId(loginId))
	{
	User user=userRepo.findByLoginId(loginId);
//	if(oldPassword.equals(user.getPassword())) {
//	loginRepo.updatePassword(user.getLoginId(), newPassword);
//	//return res;
	if(oldPassword.equals(user.getPassword())) {
		appUserRepo.updatePassword(user.getId(), newPassword);
	}
	else
	throw new InvalidPasswordException("Invalid old password");
	}
	else
	throw new UserNotFoundException("No user found for login id "+loginId);
	}

	@Override
	public void forgotPassword(String loginId, String newPassword) {
	logger.info("forgotPassword method of UserServiceImpl called",System.currentTimeMillis());
	// customerValidation.validatePassword(newPassword);
	if(userRepo.existsByLoginId(loginId))
	{
	User user=userRepo.findByLoginId(loginId);
	if(user.getLoginId().equals(loginId)) {
		appUserRepo.updatePassword(user.getId(), newPassword);
	//return res;
	}
	}
	else
	throw new UserNotFoundException("No user found for login id "+ loginId);
	}
//	@Override
//	public List<User> viewUserByRole(String role) {
//		logger.debug("viewUser by usertype service in admin service is invoked");
//		return userRepo.findByUserRole(role);
//	}

}
































// deletes info for user with specified login id after validation
/*
 * @Override public boolean deleteUser(String id) {
 * logger.info("deleteUser method of UserServiceImpl called",System.
 * currentTimeMillis());
 * 
 * if(customerRepo.existsByLoginId(id)) { Customer
 * customer=customerRepo.findByLoginId(id); customerRepo.delete(customer);
 * logger.info("details for user "+ id + " deleted",System.currentTimeMillis());
 * return true; } throw new
 * UserNotFoundException("User with login id "+id+" does not exist"); } }
 */
//returns user object for given userId
/*
 * @Override public Customer findById(long custId) {
 * logger.info("findById method of UserServiceImpl called",System.
 * currentTimeMillis());
 * 
 * if(customerRepo.existsById(custId)) return
 * customerRepo.findById(custId).get(); else throw new
 * UserNotFoundException("No user found for id "+custId); }
 */
