package com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furniture.bean.TransactionHistory;

public interface TransactionRepository extends JpaRepository<TransactionHistory, Long>{
	
	TransactionHistory findBytrId(long trId);
	

}
