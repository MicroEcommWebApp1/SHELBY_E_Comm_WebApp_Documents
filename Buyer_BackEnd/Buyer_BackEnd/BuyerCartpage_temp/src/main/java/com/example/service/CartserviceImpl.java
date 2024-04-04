package com.example.service;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.CartDto;
import com.example.entity.Cart;
import com.example.entity.TotalCartPrice;
import com.example.repository.Cartrepo;
import com.example.repository.TotalCartPricerepo;

import jakarta.transaction.Transactional;


@Service
public class CartserviceImpl implements Cartservice {
	

    
    private final Cartrepo cartrepo;
    
    
    private final ModelMapper modelMapper;
    
    
    private final TotalCartPricerepo totalcartpricerepo;
    
    @Autowired
    public CartserviceImpl(Cartrepo cartrepo,ModelMapper modelMapper,TotalCartPricerepo totalcartpricerepo) {
    	this.cartrepo=cartrepo;
    	this.modelMapper=modelMapper;
    	this.totalcartpricerepo=totalcartpricerepo;
    }
    
    
    
   
    
	@Override
	public ResponseEntity<String> addtocart(CartDto cartDto) {
		
		Cart c = this.modelMapper.map(cartDto, Cart.class);
		cartrepo.save(c);
		
		return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Data saved\"}");
		
	}
	
	@Override
	public List<CartDto> getAllCartDetails() {
		List<Cart> cartlist = cartrepo.findAll();
        if(!(cartlist.isEmpty()))
            return cartlist.stream()
    				.map(cart -> modelMapper.map(cart, CartDto.class)).toList();
        else
            return Collections.emptyList();
 
    }
	
	@Override
	public List<CartDto> getCartdetailsByEmail(String email) {
	    List<Cart> carts = cartrepo.findByEmail(email);
	    if (!carts.isEmpty()) {
	        return carts.stream()
	                    .map(cart -> modelMapper.map(cart, CartDto.class)).toList();
	    } else {
	        return Collections.emptyList();
	    }
	}
	
	 @Override
	 
	 @Transactional
	    public ResponseEntity<String> deleteShoppingCart(String email , Long productId) {
		 
	        cartrepo.deleteByEmailAndProductId(email,productId);
	        return ResponseEntity.ok("{\"message\": \"Cart item deleted successfully\"}");
	    }

	@Override
	public ResponseEntity<String> updateShoppingCart(CartDto cartDto, String email, Long productId) {
		
		TotalCartPrice totalcartprice = totalcartpricerepo.findByEmail(email);

	    if (totalcartprice == null) {
	     
	        totalcartprice = new TotalCartPrice();
	        totalcartprice.setEmail(email);
	    }
	   
	    
	    Long totalCprice = 0L;
	   
	    
	    
		List<Cart> carts = cartrepo.findByEmail(email);
		for(Cart cart : carts) {
			
			
			if (cart.getProductId()==productId) {
				cart.setQuantity(cartDto.getQuantity());
				cart.setTotalproductPrice(cartDto.getTotalproductPrice());
				Cart c = this.modelMapper.map(cart, Cart.class);
				cartrepo.save(c);
			}
			
			totalCprice += cart.getTotalproductPrice();
			
			totalcartpricerepo.save(totalcartprice);
			
		}
		return ResponseEntity.ok("{\"message\": \"quantity increased\"}");
	}





	@Override
	 @Transactional
	public ResponseEntity<String> deleteListOfProductsByEmail(String email) {
		cartrepo.deleteByEmail(email);
		return ResponseEntity.ok("{\"message\": \"Deleted Successfully\"}");
	}
	
	
	 
	 

}
