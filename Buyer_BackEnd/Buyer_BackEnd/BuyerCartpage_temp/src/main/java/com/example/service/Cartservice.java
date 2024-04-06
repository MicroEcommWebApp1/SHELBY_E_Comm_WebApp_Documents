package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.CartDto;

@Service
public interface Cartservice {

	ResponseEntity<String> addtocart(CartDto cartDto);

	List<CartDto> getAllCartDetails();

	ResponseEntity<String> deleteShoppingCart(String email, Long productId);

	List<CartDto> getCartdetailsByEmail(String email);

	ResponseEntity<String> updateShoppingCart(CartDto cartDto, String email, Long productId);

	ResponseEntity<String> deleteListOfProductsByEmail(String email);

}
