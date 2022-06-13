package com.furniture.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furniture.bean.TransactionHistory;
import com.furniture.exception.EmptyOrderException;
import com.furniture.exception.InvalidDetailsException;
import com.furniture.repository.TransactionRepository;
@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService{
	
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public TransactionHistory viewTransactions(long trId) {
		log.info("Transaction History");
		TransactionHistory history = transactionRepository.findBytrId(trId);
		if (history == null)
			throw new InvalidDetailsException("Transaction Not Found");
		else
			return history;
	}

	@Override
	public List<TransactionHistory> viewAllTransaction() {
		log.info("Entered viewAllProducts()");
		List<TransactionHistory> all = transactionRepository.findAll();
		if (all.isEmpty()) {
			throw new EmptyOrderException("Transactions not Found");
		}
		return all;
	}

	@Override
	public TransactionHistory updateStatus(long trId, TransactionHistory transactionHistory) {
		transactionHistory.setDelStatus("In Process");
		log.info("Entered updateStatus()");
		TransactionHistory history = transactionRepository.findById(trId).get();
		if (history == null)
			throw new InvalidDetailsException("Transaction Not Found");
		else
			return history;
	}
	}
	
	
