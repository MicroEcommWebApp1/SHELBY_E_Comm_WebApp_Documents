package com.sellerregistrationservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sellerregistrationservice.dto.LoginDTO;
import com.sellerregistrationservice.dto.SellerRegistrationDTO;

@Service
public interface SellerRegistrationService {
	SellerRegistrationDTO createSellerRegistration(SellerRegistrationDTO sellerRegistrationDTO);

	List<SellerRegistrationDTO> getAllSellerRegistrations();

	boolean validateLogin(LoginDTO loginRequest);

	boolean existsByEmailID(String emailID);

	ResponseEntity<String> forgotPassword(String email);

	ResponseEntity<String> updateProfile(SellerRegistrationDTO profiledto);

	ResponseEntity<?> getbyid(Long id);
	public List<SellerRegistrationDTO> getSellerDetailsByEmail(String emailID);

	int getSellerCount();

}