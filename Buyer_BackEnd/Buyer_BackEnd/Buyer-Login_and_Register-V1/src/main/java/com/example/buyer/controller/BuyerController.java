package com.example.buyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.buyer.entity.Buyer;
import com.example.buyer.entity.Login;
import com.example.buyer.service.BuyerService;

@RestController
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;
	
	@PostMapping("/save")
	public String saveBuyer(@RequestBody Buyer buyer) {
		return buyerService.saveBuyer(buyer);
	}
	
	@PostMapping("/login")
	public String loginBuyer(@RequestBody Login login) {
		return buyerService.loginBuyer(login);
	}

}
