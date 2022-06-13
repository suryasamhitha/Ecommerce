package com.furniture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.furniture.bean.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
//	@Query( value = "SELECT u FROM User u WHERE u.role =:givenUserRole")
//	List<User> findByUserRole(@Param("givenUserRole")String Role);
	User findByLoginId(String loginId);
//	User findByPassword(String Password);
	boolean existsByLoginId(String loginId);
	boolean existsByPhoneNo(String PhoneNo);
	boolean existsByEmail(String email);
}
