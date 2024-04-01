package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Dto.CartDto;
import com.example.service.Cartservice;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private Cartservice cartservice;

	@PostMapping("/cart")
	public ResponseEntity<?> addtocart(@RequestBody CartDto cartDto){
		 return cartservice.addtocart(cartDto);
	}
	
	@GetMapping("/cartdetails")  
	public List<CartDto> getAllCartDetails(){	
		return cartservice.getAllCartDetails();
	}
	
	@GetMapping("/cartdetails/{email}")
    public List<CartDto> getCartdetailsByEmail(@PathVariable String email) {
        return cartservice.getCartdetailsByEmail(email);
    }
	
	
	@DeleteMapping("/delcart/{email}/{product_id}")
	public ResponseEntity<String> deleteShoppingCart(@PathVariable String email, @PathVariable Long product_id) {
        return cartservice.deleteShoppingCart(email, product_id);
    }

	

}
