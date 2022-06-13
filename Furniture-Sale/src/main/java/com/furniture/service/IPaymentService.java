package com.furniture.service;

import org.springframework.stereotype.Component;

import com.furniture.bean.Payment;
import com.furniture.exception.PaymentException;

@Component
public interface IPaymentService {
	
		public Payment addPayment(Payment payment);
		
		public Payment deletePayment(int paymentId) throws PaymentException;
		
		public Payment viewPaymentDetailsById(int paymentId)throws PaymentException;
		public Iterable<Payment> getAllPayments();

	}

