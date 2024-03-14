package com.buyer.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class BuyerDto {
	
	private Long id;
	
	private String name;
	
	@NotEmpty
	@Pattern(regexp = ".*@gmail\\.com$")
	private String email;
	
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{8,}$")
	private String password;
	
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phonenumber;
	

}
