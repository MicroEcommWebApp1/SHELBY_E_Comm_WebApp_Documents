package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.Dto.CartDto;



public interface Cartservice {

	ResponseEntity<String> addtocart(CartDto cartDto);

	

	

	
	List<CartDto> getAllCartDetails();

	ResponseEntity<String> deleteShoppingCart(String email,Long productId);

	List<CartDto> getCartdetailsByEmail(String email);


}
