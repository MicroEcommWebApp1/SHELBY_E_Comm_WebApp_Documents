package com.buyer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.buyer.dto.BuyerDto;
import com.buyer.dto.LoginDto;

public interface BuyerService {

	public ResponseEntity<String> buyerRegistration(BuyerDto buyerDto);

	public ResponseEntity<?> buyerLogin(LoginDto login);

	public ResponseEntity<String> update(BuyerDto buyerDto);

	public ResponseEntity<String> getPasswordtoemail(String email);
    public List<BuyerDto> getAllBuyerDetails();
	
	public List<BuyerDto> getBuyerdetailsByEmail(String email);

}
