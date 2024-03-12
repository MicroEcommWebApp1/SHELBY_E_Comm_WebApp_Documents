package com.buyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buyer.entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Long>{

	Buyer findByEmail(String email);
}
