package com.paymentservice.service;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.paymentservice.dto.PaymentDto;
import com.paymentservice.model.Payment;
import com.paymentservice.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	private final PaymentRepository paymentrepo;
	private final ModelMapper modelMapper;

	@Override
	public ResponseEntity<String> addtoPayment(PaymentDto paymentDto) {
		Payment payment = this.modelMapper.map(paymentDto, Payment.class);
		paymentrepo.save(payment);
		return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Payment Details saved\"}");

	}

	@Override
	public List<PaymentDto> getAllPayments() {
		List<Payment> paymentlist = paymentrepo.findAll();
		if (!(paymentlist.isEmpty()))
			return paymentlist.stream().map(payment -> modelMapper.map(payment, PaymentDto.class)).toList();
		else
			return Collections.emptyList();

	}

	@Override
	public List<PaymentDto> getPaymentdetailsByEmail(String email) {
		List<Payment> payments = paymentrepo.findByEmail(email);
		if (!payments.isEmpty()) {
			return payments.stream().map(payment -> modelMapper.map(payment, PaymentDto.class)).toList();
		} else {
			return Collections.emptyList();
		}
	}

}
