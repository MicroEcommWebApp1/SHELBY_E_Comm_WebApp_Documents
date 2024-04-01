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
	
	  private final Cartservice cartservice;
	  
	  @Autowired
	    public CartController(Cartservice cartservice) {
	        this.cartservice = cartservice;
	        
	    }

	@PostMapping("/cart")
	public ResponseEntity<String> addtocart(@RequestBody CartDto cartDto){
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
	
	
	@DeleteMapping("/delcart/{email}/{productId}")
	public ResponseEntity<String> deleteShoppingCart(@PathVariable String email, @PathVariable Long productId) {
        return cartservice.deleteShoppingCart(email, productId);
      
    }


}
