package com.example.buyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buyer.entity.Buyer;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer,Long>{

	Buyer findByEmail(String email);
}
