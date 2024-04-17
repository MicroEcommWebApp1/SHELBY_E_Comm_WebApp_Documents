package com.buyer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.buyer.dto.PaymentDto;



@FeignClient(name="paymentservice")
public interface Buyerfeign {
	@PostMapping("/payment/payment")
	public ResponseEntity<String> addPayment(@RequestBody PaymentDto paymentDto);
}
