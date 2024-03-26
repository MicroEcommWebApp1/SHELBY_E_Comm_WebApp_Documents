package com.buyer.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BuyerDto {

	private int id;

	private String name;

	@NotEmpty
	@Pattern(regexp = ".*@gmail\\.com$", message = "Email must contain @gmail.com")
	private String email;

	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{8,}$", message = "password should contain min 8 characters with alphabets,numeric and special character ")
	private String password;

	@Pattern(regexp = "([0-9]{10})", message = "phonenumber must contain 10 digits")
	private String phonenumber;

}
