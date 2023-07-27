package com.prfs.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prfs.hrpayroll.entities.Payment;
import com.prfs.hrpayroll.entities.Worker;
import com.prfs.hrpayroll.feighnCliente.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFC;

	public Payment getPayment(long workerId, int days) {
		// Tipo esta declarado na classe worker
		Worker worker = workerFC.findById(workerId).getBody();// corpo da resposta
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
