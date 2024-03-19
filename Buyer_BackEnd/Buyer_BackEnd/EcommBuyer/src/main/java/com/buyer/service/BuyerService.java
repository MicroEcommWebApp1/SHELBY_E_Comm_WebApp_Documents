package com.buyer.service;

import org.springframework.http.ResponseEntity;

import com.buyer.dto.BuyerDto;
import com.buyer.dto.LoginDto;


public interface BuyerService {

	public ResponseEntity<?> buyerRegistration(BuyerDto buyerDto);

	public ResponseEntity<?> buyerLogin(LoginDto login);

	public ResponseEntity<?> update(BuyerDto buyerDto);

	public ResponseEntity<?> getPasswordtoemail(String email);

}
