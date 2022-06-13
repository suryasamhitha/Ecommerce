package com.furniture.service;

import com.furniture.bean.User;

public interface ILoginService {
	
//	public User Login(User user);

	User login(String loginId, String password);

}
