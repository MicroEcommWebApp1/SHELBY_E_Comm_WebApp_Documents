package com.sellerregistrationservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sellerregistrationservice.dto.LoginDTO;
import com.sellerregistrationservice.dto.SellerRegistrationDTO;
import com.sellerregistrationservice.service.SellerRegistrationService;

@ExtendWith(MockitoExtension.class)
class SellerRegistrationControllerTest {
	@Mock
	private SellerRegistrationService sellerRegistrationService;

	@InjectMocks
	private SellerRegistrationController sellerRegistrationController;

	@Test
	void testCreateSellerRegistration_Positive() {
		// Mocking behavior
		SellerRegistrationDTO requestDTO = SellerRegistrationDTO.builder().name("Jamesbond")
				.emailID("jamesbond@example.com").companyName("DXC Corporation").gstNumber("12ABCDE1234F1Z5")
				.companyAddress("123 Main Street").phoneNumber("987243211").password("Password@123").build();

		// Adjust the behavior of existsByEmailID() method
		when(sellerRegistrationService.existsByEmailID(eq(requestDTO.getEmailID()))).thenReturn(false);

		// Performing the test
		ResponseEntity<?> responseEntity = sellerRegistrationController.createSellerRegistration(requestDTO);

		// Assertions
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		 assertEquals("{\"message\": \"Seller registration successful\"}", responseEntity.getBody());
		verify(sellerRegistrationService).createSellerRegistration(any(SellerRegistrationDTO.class));
	}

	@Test
	void testCreateSellerRegistration_Negative() {
		// Mocking behavior
		SellerRegistrationDTO requestDTO = SellerRegistrationDTO.builder().name("Jamesbond")
				.emailID("jamesbond@gmail.com") // Email ID already exists
				.companyName("DXC Corporation").gstNumber("12ABCDE1234F1Z5").companyAddress("123 Main Street")
				.phoneNumber("987243211").password("Password@123").build();

		// Adjust the behavior of existsByEmailID() method
		when(sellerRegistrationService.existsByEmailID(eq(requestDTO.getEmailID()))).thenReturn(true);

		// Performing the test
		ResponseEntity<?> responseEntity = sellerRegistrationController.createSellerRegistration(requestDTO);

		// Assertions
		assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
		assertEquals("{\"message\": \"EmailID already Exists\"}", responseEntity.getBody());
		verify(sellerRegistrationService, times(0)).createSellerRegistration(any(SellerRegistrationDTO.class));
	}

	@Test
	void testGetAllSellerRegistrations_Positive() {
		// Mocking behavior
		List<SellerRegistrationDTO> sellerRegistrations = Collections
				.singletonList(SellerRegistrationDTO.builder().name("Jamesbond").emailID("jamesbond@gmail.com")
						.companyName("DXC Corporation").gstNumber("12ABCDE1234F1Z5").companyAddress("123 Main Street")
						.phoneNumber("987243211").password("Password@123").build());
		when(sellerRegistrationService.getAllSellerRegistrations()).thenReturn(sellerRegistrations);

		// Performing the test
		ResponseEntity<List<SellerRegistrationDTO>> responseEntity = sellerRegistrationController
				.getAllSellerRegistrations();

		// Assertions
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(sellerRegistrations, responseEntity.getBody());
	}

	@Test
	     void testGetAllSellerRegistrations_Negative() {
	        // Mocking behavior
	        when(sellerRegistrationService.getAllSellerRegistrations()).thenReturn(Collections.emptyList());

	        // Performing the test
	        ResponseEntity<List<SellerRegistrationDTO>> responseEntity = sellerRegistrationController.getAllSellerRegistrations();

	        // Assertions
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // We expect HttpStatus.OK now
	        assertEquals(Collections.emptyList(), responseEntity.getBody());
	    }

	@Test
	void testLogin_Positive() {
		// Mocking behavior
		LoginDTO loginRequest = new LoginDTO("jamesbond@gmail.com", "Password@123"); // Provide necessary data
		when(sellerRegistrationService.validateLogin(loginRequest)).thenReturn(true);

		// Performing the test
		ResponseEntity<String> responseEntity = sellerRegistrationController.login(loginRequest);

		// Assertions
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("{\"message\": \"Login successful\"}", responseEntity.getBody());
	}

	@Test
	void testLogin_Negative() {
		// Mocking behavior
		LoginDTO loginRequest = new LoginDTO("jamesbond@gmail.com", "Password@1234"); // Provide necessary data
		when(sellerRegistrationService.validateLogin(loginRequest)).thenReturn(false);

		// Performing the test
		ResponseEntity<String> responseEntity = sellerRegistrationController.login(loginRequest);

		// Assertions
		assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
		assertEquals("{\"message\": \"Invalid email or password\"}", responseEntity.getBody());
	}
}
