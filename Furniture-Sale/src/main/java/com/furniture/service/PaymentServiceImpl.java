package com.furniture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.bean.Payment;
import com.furniture.exception.PaymentException;
import com.furniture.repository.PaymentRepository;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService{
	
	Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentRepository paymentRepo;

	
	public Payment addPayment(Payment payment) {
		
		log.info("add Payment method of ProductOrderServiceImpl called", System.currentTimeMillis());
		return paymentRepo.save(payment);
	}


	public Payment deletePayment(int paymentId) throws PaymentException {
		
		log.info("delete Payment method of ProductOrderServiceImpl called", System.currentTimeMillis());
		Payment payment=paymentRepo.findByPaymentId(paymentId);
		paymentRepo.deleteById(paymentId);
		return payment;
			}

	
	public Payment viewPaymentDetailsById(int paymentId) throws PaymentException{
		log.info("viewPaymentDetails method of ProductOrderServiceImpl called", System.currentTimeMillis());
		return paymentRepo.findByPaymentId(paymentId);
		
	}

	@Override
	public Iterable<Payment> getAllPayments() {
		log.info("getAllPayment method of ProductOrderServiceImpl called", System.currentTimeMillis());

		return paymentRepo.findAll();
	}

}

