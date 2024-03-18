package com.SellerRegistrationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Data
@Table(name="seller_registration")
@NoArgsConstructor
@AllArgsConstructor
public class SellerRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true) 
    private String emailID;
	private String companyName;
	private String gstNumber;
	private String companyAddress;
	private String phoneNumber;
	private String password;

	@CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updated_at;
	

}
