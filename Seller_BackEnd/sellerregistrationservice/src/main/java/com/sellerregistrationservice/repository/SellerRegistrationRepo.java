package com.sellerregistrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sellerregistrationservice.model.SellerRegistration;

public interface SellerRegistrationRepo extends JpaRepository<SellerRegistration, Integer> {

	SellerRegistration findBySellerEmailID(String email);

	boolean existsBySellerEmailID(String emailID);

	SellerRegistration findById(Long id);
}