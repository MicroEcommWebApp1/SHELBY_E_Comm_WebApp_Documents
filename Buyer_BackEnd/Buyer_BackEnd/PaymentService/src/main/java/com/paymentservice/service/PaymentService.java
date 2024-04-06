package com.paymentservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paymentservice.dto.PaymentDto;
@Service
public interface PaymentService {
	ResponseEntity<String> addtoPayment(PaymentDto paymentDto);

	List<PaymentDto> getAllPayments();

	List<PaymentDto> getPaymentdetailsByEmail(String email);

}
