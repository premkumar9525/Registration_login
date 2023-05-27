package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PaymentDetails;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private  PaymentRepository paymentRepository;

	public void savepayment(PaymentDetails paymentDetails) {
		paymentRepository.save(paymentDetails);
		
	}

	public List<PaymentDetails> findAll() {
		return paymentRepository.findAll();
	}

	public void saveEmi(PaymentDetails paymentDetails) {
		paymentRepository.save(paymentDetails);
	}


}
