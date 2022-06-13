package com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.furniture.bean.CartItem;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	
	@Query("select c from CartItem c where c.customerLoginId.loginId=:loginId")
	public CartItem viewCartByCustomerId(@Param("loginId")Long loginId);

}
