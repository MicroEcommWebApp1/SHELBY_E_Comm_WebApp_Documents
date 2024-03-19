package com.buyer.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.buyer.dto.BuyerDto;
import com.buyer.dto.LoginDto;
import com.buyer.service.BuyerService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(BuyerController.class)

public class BuyerControllerTest {
	
	@MockBean
	private BuyerService buyerService;
	
	@Autowired 
	private MockMvc mockMvc;
	private BuyerDto buyerDto;
	private LoginDto login;
	private String testEmail;
    private String testPassword;
	
	@BeforeEach
	void setup() {
		buyerDto = BuyerDto.builder()
				 .id(1)
				 .name("Swetha")
				 .email("swetha333555@gmail.com")
				 .password("swetha08!")
				 .phonenumber("9876543211")
				 .build();
		}

		
	@Test 
	public void buyerRegistrationTest() throws Exception {
		when(buyerService.buyerRegistration(buyerDto)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		mockMvc.perform(post("/buyer/register")
		.contentType("application/json")
		.content(new ObjectMapper().writeValueAsString(buyerDto)))
        .andExpect(status().isOk());
	}
	
	
	@BeforeEach
	public void setup1() {
		login = LoginDto.builder()
				 .email("swetha333555@gmail.com")
				 .password("swetha08!")
				 .build();
		}

	@Test
	public void buyerLogin_Test() throws Exception {
		when(buyerService.buyerLogin(login)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
		mockMvc.perform(post("/buyer/login")
		.contentType("application/json")
		.content(new ObjectMapper().writeValueAsString(login)))
        .andExpect(status().isOk());
	}
	
	@BeforeEach
	void setup3() {
		testEmail = "swetha333555@gmail.com";
        testPassword = "swetha08!";
		}
	
	
  /*  public void testForgotPassword() throws Exception {
		
        // Mocking buyerService.forgotPassword method
        when(buyerService.forgotPassword(testEmail, testPassword)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        mockMvc.perform(put("/buyer/forgotpassword/swetha333555@gmail.com/swetha08!")
        		.contentType("application/json")
        		.content(new ObjectMapper().writeValueAsString(testPassword)))
                .andExpect(status().isOk());
    } */
	

}
