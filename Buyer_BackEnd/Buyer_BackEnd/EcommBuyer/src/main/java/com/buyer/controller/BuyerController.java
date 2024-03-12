package com.buyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buyer.dto.BuyerDto;
import com.buyer.dto.LoginDto;
import com.buyer.service.BuyerService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> buyerRegistration(@RequestBody BuyerDto buyerDto){
		return buyerService.buyerRegistration(buyerDto);
	}
	@PostMapping("/login")
	public ResponseEntity<?> buyerLogin(@RequestBody LoginDto login){
		return buyerService.buyerLogin(login);
		
	}
	@PutMapping("/forgotpassword/{email}/{password}")
	public ResponseEntity<?> forgotPassword(@PathVariable String email,@PathVariable String password){
		return buyerService.forgotPassword(email,password);
	}

}
