package com.furniture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.bean.User;
import com.furniture.exception.InvalidPasswordException;
import com.furniture.exception.UserNotFoundException;
import com.furniture.repository.LoginRepository;
import com.furniture.repository.UserRepository;


@Service
@Transactional
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private LoginRepository loginRepo;
	@Autowired
	private UserRepository userRepo;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);	
	@Override
	public User login(String loginId, String password) {
		
		logger.info("login method of UserServiceImpl called",System.currentTimeMillis());

		if(userRepo.existsByLoginId(loginId))
		{
			User user=userRepo.findByLoginId(loginId);
			
			if(password.equals(user.getPassword())) {
				logger.info("password for user "+ loginId +" authenticated",System.currentTimeMillis());
				return user;
				}
			else
				throw new InvalidPasswordException("Invalid password for login id "+loginId);
		}
	
	throw new UserNotFoundException("No user found for login id "+loginId);
}
	
//	@Override
//	public User Login(User user) {
//		logger.debug("login service in login service is invoked");
//		User cred = loginRepo.findById(user.getId());
//		if (cred == null) {
//			throw new UserNotFoundException("User not Found!!!!!");
//		}
//		if (cred.getId()==user.getId() && cred.getLoginId()==user.getLoginId() && cred.getPassword().equals(user.getPassword())) {
//		return  cred;
//		}
//		throw new InvalidPasswordException("Invalid Password!!!!!");
//	}


}
