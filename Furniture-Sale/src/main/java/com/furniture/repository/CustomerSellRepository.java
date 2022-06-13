package com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.furniture.bean.CustomerSell;

@Repository
public interface CustomerSellRepository extends JpaRepository<CustomerSell, Long> {
	
	@Query("select c from CustomerSell c where c.sellId=:sellId")
	public CustomerSell viewProductById(@Param("sellId")Long sellId);

}
