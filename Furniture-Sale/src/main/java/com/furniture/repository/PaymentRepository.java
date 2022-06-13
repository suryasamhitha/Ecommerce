package com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.bean.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
	Payment findByPaymentId(int paymentId);
}