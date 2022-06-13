package com.furniture.service;

import java.util.List;

import com.furniture.bean.User;

public interface IUserService {
	
	User addUser(User user);
	User updateUser(User user);
	User findById(long id);
	User findByLoginId(String loginId);
//	List<User> viewUserByRole(String role);
	public void changePassword(String loginId, String oldPassword, String newPassword);
	public void forgotPassword(String loginId, String newPassword);
	
}