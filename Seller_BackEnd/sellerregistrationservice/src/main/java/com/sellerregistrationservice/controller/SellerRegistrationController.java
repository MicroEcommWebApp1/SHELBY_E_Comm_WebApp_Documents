package com.sellerregistrationservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sellerregistrationservice.dto.LoginDTO;
import com.sellerregistrationservice.dto.SellerRegistrationDTO;
import com.sellerregistrationservice.service.SellerRegistrationService;

import jakarta.validation.Valid;

@Validated
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/seller-registrations")
public class SellerRegistrationController {
	private final SellerRegistrationService sellerRegistrationService;

	@Autowired
	public SellerRegistrationController(SellerRegistrationService sellerRegistrationService) {
		this.sellerRegistrationService = sellerRegistrationService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> createSellerRegistration(
			@Valid @RequestBody SellerRegistrationDTO sellerRegistrationDTO) {
		try {
			// Check if the email ID already exists
			if (sellerRegistrationService.existsByEmailID(sellerRegistrationDTO.getSellerEmailID())) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"EmailID already Exists\"}");

			}

			sellerRegistrationService.createSellerRegistration(sellerRegistrationDTO);
			return ResponseEntity.ok("{\"message\": \"Seller registration successful\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to create seller registration: " + e.getMessage());
		}
	}

	@GetMapping("/registereddetails")
	public ResponseEntity<List<SellerRegistrationDTO>> getAllSellerRegistrations() {
		List<SellerRegistrationDTO> sellerRegistrationsDTO = sellerRegistrationService.getAllSellerRegistrations();
		if (sellerRegistrationsDTO.isEmpty()) {
			return ResponseEntity.ok(Collections.emptyList()); // Return an empty list
		} else {
			return ResponseEntity.ok(sellerRegistrationsDTO);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginRequest) {
		if (loginRequest == null || loginRequest.getSellerEmailID().isEmpty() || loginRequest.getPassword().isEmpty()) {
			return ResponseEntity.badRequest().body("{\"message\": \"EmailID or Password can't be empty\"}");
		}

		boolean isValidLogin = sellerRegistrationService.validateLogin(loginRequest);
		if (isValidLogin) {
			return ResponseEntity.ok("{\"message\": \"Login successful\"}");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Invalid email or password\"}");
		}
	}

	@GetMapping("/forgotpassword/{email}")
	public ResponseEntity<String> forgotPassword(@PathVariable String email) {
		return sellerRegistrationService.forgotPassword(email);
	}

	@PutMapping("/updateprofile")
	public ResponseEntity<String> updateProfile(@Valid @RequestBody SellerRegistrationDTO profiledto) {
		return sellerRegistrationService.updateProfile(profiledto);
	}

	@GetMapping("/getdet/{id}")
	public ResponseEntity<?> getdetailsonid(@PathVariable Long id) {
		return sellerRegistrationService.getbyid(id);
	}
	@GetMapping("/sellerdetails/{emailID}")
	public List<SellerRegistrationDTO> getSellerDetailsByEmail(@PathVariable String emailID) {
	    return sellerRegistrationService.getSellerDetailsByEmail(emailID);
	}
	@GetMapping("/getcount")
	public int getSellerCount() {
		return sellerRegistrationService.getSellerCount();
	}
}
