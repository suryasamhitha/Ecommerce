package com.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.furniture.bean.AppUser;
import com.furniture.bean.User;
import com.furniture.service.UserServiceImpl;

@SpringBootApplication

public class FurnitureSaleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FurnitureSaleApplication.class, args);
	}
	@Autowired
	public UserServiceImpl userServiceImpl;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		AppUser appUser= new AppUser(100,"abcd123","analyst");
//		User user=new User(102,"xyz","b","122","abc@gmail.com","9876543210",appUser);
//		User u=userServiceImpl.addUser(user);
//		System.out.println(u);
	}

}
