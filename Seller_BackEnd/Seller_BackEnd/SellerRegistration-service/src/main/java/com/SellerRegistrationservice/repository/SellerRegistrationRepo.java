package com.SellerRegistrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SellerRegistrationservice.model.SellerRegistration;

public interface SellerRegistrationRepo extends JpaRepository<SellerRegistration, Integer> {
	SellerRegistration findByEmailID(String email);
}
