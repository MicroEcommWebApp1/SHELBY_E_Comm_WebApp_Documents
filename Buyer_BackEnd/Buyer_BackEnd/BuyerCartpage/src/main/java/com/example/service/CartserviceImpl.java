package com.example.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Dto.CartDto;
import com.example.entity.Cart;
import com.example.repository.Cartrepo;

import jakarta.transaction.Transactional;


@Service
public class CartserviceImpl implements Cartservice {
	

    @Autowired
    private Cartrepo cartrepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
	@Override
	public ResponseEntity<?> addtocart(CartDto cartDto) {	
		Cart c = this.modelMapper.map(cartDto, Cart.class);
		cartrepo.save(c);
		return new ResponseEntity<>("Data saved", HttpStatus.OK);
	}
	
	@Override
	public List<CartDto> getAllCartDetails() {
		List<Cart> cartlist = cartrepo.findAll();
        if(cartlist.size()>0)
            return cartlist.stream()
    				.map(cart -> modelMapper.map(cart, CartDto.class))
    				.collect(Collectors.toList());
        else
            return null;
 
    }
	
	@Override
	public List<CartDto> getCartdetailsByEmail(String email) {
	    List<Cart> carts = cartrepo.findByEmail(email);
	    if (!carts.isEmpty()) {
	        return carts.stream()
	                    .map(cart -> modelMapper.map(cart, CartDto.class))
	                    .collect(Collectors.toList());
	    } else {
	        return Collections.emptyList();
	    }
	}
	
	@Override
	@Transactional
	public ResponseEntity<String> deleteShoppingCart(String email, Long product_id) {
	    Optional<Cart> cartOptional = cartrepo.findById(product_id);
	    if (cartOptional.isPresent()) {
	        Cart cart = cartOptional.get();
	        if (cart.getEmail().equals(email)) {
	            cartrepo.delete(cart);
	            return ResponseEntity.ok("Cart item deleted successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Cannot delete cart item: incorrect email");
	        }
	    } else {
	        return ResponseEntity.badRequest().body("Cannot delete cart item: product not found");
	    }
	}
}


