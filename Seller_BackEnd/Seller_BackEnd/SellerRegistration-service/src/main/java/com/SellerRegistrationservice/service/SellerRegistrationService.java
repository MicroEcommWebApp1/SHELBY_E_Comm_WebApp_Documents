package com.SellerRegistrationservice.service;

import com.SellerRegistrationservice.dto.LoginDTO;
import com.SellerRegistrationservice.dto.SellerRegistrationDTO;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface SellerRegistrationService {
	SellerRegistrationDTO createSellerRegistration(SellerRegistrationDTO sellerRegistrationDTO);

	List<SellerRegistrationDTO> getAllSellerRegistrations();

	boolean validateLogin(LoginDTO loginRequest);

	boolean existsByEmailID(String emailID);

	ResponseEntity<?> forgotPassword(String email);

	ResponseEntity<?> updateProfile(SellerRegistrationDTO profiledto);

}