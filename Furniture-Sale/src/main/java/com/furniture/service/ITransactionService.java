package com.furniture.service;

import java.util.List;

import com.furniture.bean.TransactionHistory;

public interface ITransactionService {

	TransactionHistory viewTransactions(long trId);

	List<TransactionHistory> viewAllTransaction();
	
	TransactionHistory updateStatus( long trId, TransactionHistory transactionHistory);

}
