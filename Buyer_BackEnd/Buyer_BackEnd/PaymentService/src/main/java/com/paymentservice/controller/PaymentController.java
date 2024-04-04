package com.paymentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.dto.PaymentDto;
import com.paymentservice.service.PaymentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PaymentController {
	private final PaymentService paymentservice;

	@Autowired
	public PaymentController(PaymentService paymentservice) {
		this.paymentservice = paymentservice;

	}

	@PostMapping("/payment")
	public ResponseEntity<String> addPayment(@RequestBody PaymentDto paymentDto) {
		return paymentservice.addtoPayment(paymentDto);
	}

	@GetMapping("/paymentdetails")
	public List<PaymentDto> getAllPaymentslist() {
		return paymentservice.getAllPayments();
	}

	@GetMapping("/paymentdetails/{email}")
	public List<PaymentDto> getPaymentdetailsByEmaillist(@PathVariable String email) {
		return paymentservice.getPaymentdetailsByEmail(email);
	}

}
