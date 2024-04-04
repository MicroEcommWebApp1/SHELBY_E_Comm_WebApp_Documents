package com.paymentservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paymentservice.dto.PaymentDto;

public interface PaymentService {
	ResponseEntity<String> addtoPayment(PaymentDto paymentDto);

	List<PaymentDto> getAllPayments();

	List<PaymentDto> getPaymentdetailsByEmail(String email);

}
