package com.buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.buyer.dto.BuyerDto;
import com.buyer.dto.LoginDto;

import com.buyer.service.BuyerService;

import jakarta.validation.Valid;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/buyer")
public class BuyerController {

	private final BuyerService buyerService;

	@Autowired
	public BuyerController(BuyerService buyerService) {
	    this.buyerService = buyerService;
	}


	@PostMapping("/register")
	public ResponseEntity<String> buyerRegistration(@Valid @RequestBody BuyerDto buyerDto) {
		return buyerService.buyerRegistration(buyerDto);
	}

	@PostMapping("/login")
	public ResponseEntity<?> buyerLogin(@RequestBody LoginDto login) {
		return buyerService.buyerLogin(login);

	}

	@PutMapping("/updateprofile")
	public ResponseEntity<String> update(@Valid @RequestBody BuyerDto buyerDto) {
		return buyerService.update(buyerDto);
	}

	@GetMapping("/forgotpassword/{email}")
	public ResponseEntity<String> getPasswordtoemail(@PathVariable String email) {
		return buyerService.getPasswordtoemail(email);
	}
	@GetMapping("/registereddetails")
	public List<BuyerDto> getAllBuyerDetails(){	
		return buyerService.getAllBuyerDetails();
	}
 
	@GetMapping("/buyerdetails/{email}")
    public List<BuyerDto> getBuyerdetailsByEmail(@PathVariable String email) {
        return buyerService.getBuyerdetailsByEmail(email);
    }
	@GetMapping("/getcount")
	public int getBuyerCount() {
		return buyerService.getBuyerCount();
	}
}
