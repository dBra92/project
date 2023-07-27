package com.prfs.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prfs.hrpayroll.entities.Payment;
import com.prfs.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}") // o valor que irá pegar contido no application.properties
	private String workerHost;
	@Autowired
	public RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", "" + workerId);
		
		// Tipo esta declarado na classe worker
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
