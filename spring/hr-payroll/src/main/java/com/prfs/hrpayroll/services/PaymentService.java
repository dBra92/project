package com.prfs.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.prfs.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Jorjao", 300.01, days);
	}
}
