package com.SellerRegistrationservice.controller;

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

import com.SellerRegistrationservice.dto.LoginDTO;
import com.SellerRegistrationservice.dto.SellerRegistrationDTO;
import com.SellerRegistrationservice.service.SellerRegistrationService;

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
	public ResponseEntity<?> createSellerRegistration(@Valid @RequestBody SellerRegistrationDTO sellerRegistrationDTO) {
		try {
			// Check if the email ID already exists
			if (sellerRegistrationService.existsByEmailID(sellerRegistrationDTO.getEmailID())) {
				return new ResponseEntity<>("Email ID already exists", HttpStatus.CONFLICT);
			}

			sellerRegistrationService.createSellerRegistration(sellerRegistrationDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body("Seller registration created successfully");
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to create seller registration: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
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
		if (loginRequest == null || loginRequest.getEmailID().isEmpty() || loginRequest.getPassword().isEmpty()) {
			return new ResponseEntity<>("EmailID or Password can't be empty", HttpStatus.BAD_REQUEST);
		}

		boolean isValidLogin = sellerRegistrationService.validateLogin(loginRequest);
		if (isValidLogin) {
			return new ResponseEntity<>("Login successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/forgotpassword/{email}")
	public ResponseEntity<?> forgotPassword(@PathVariable String email) {
		return sellerRegistrationService.forgotPassword(email);
	}

	@PutMapping("/updateprofile")
	public ResponseEntity<?> updateProfile(@Valid @RequestBody SellerRegistrationDTO profiledto) {
		return sellerRegistrationService.updateProfile(profiledto);
	}

	@GetMapping("/getdet/{id}")
	public ResponseEntity<?> getdetailsonid(@PathVariable Long id) {
		return sellerRegistrationService.getbyid(id);
	}

}
