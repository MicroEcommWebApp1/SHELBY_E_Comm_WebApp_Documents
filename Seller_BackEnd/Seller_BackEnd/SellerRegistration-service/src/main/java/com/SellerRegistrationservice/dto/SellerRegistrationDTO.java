package com.SellerRegistrationservice.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SellerRegistrationDTO {
	private int id;
	private String name;
	@NotEmpty
	@Pattern(regexp = ".*@gmail\\.com$")
	private String emailID;
	private String companyName;
	@Pattern(regexp="^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$")
	private String gstNumber;
	private String companyAddress;
	@Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number must have 10 digits")
	private String phoneNumber;
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{8,}$")
	private String password;
}