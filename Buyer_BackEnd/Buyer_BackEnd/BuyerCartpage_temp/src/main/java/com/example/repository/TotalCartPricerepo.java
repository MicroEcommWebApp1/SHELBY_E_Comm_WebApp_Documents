package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TotalCartPrice;


@Repository
public interface TotalCartPricerepo extends JpaRepository<TotalCartPrice,String> {
	   
	
	TotalCartPrice findByEmail(String email);
	
	
	

}
