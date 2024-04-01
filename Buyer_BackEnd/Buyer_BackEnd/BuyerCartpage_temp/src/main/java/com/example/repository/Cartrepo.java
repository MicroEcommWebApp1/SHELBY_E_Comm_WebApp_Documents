package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.entity.Cart;

@Repository
public interface Cartrepo extends JpaRepository<Cart,Long>{

	    @Modifying
	    @Query("DELETE FROM Cart c WHERE c.email = :email AND c.productId = :productId")
	    void deleteByEmailAndProductId(String email, Long productId);
	
	    List<Cart> findByEmail(String email);

	
	
}
