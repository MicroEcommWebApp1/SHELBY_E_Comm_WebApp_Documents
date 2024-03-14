package com.SellerRegistrationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Data
@Table(name="seller_registration")
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

}
