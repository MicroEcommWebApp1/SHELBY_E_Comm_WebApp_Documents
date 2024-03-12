package com.SellerRegistrationservice.dto;

import lombok.Data;

@Data
public class SellerRegistrationDTO {
	private int id;
	private String name;
	private String emailID;
	private String companyName;
	private String gstNumber;
	private String companyAddress;
	private Long phoneNumber;
	private String password;
}