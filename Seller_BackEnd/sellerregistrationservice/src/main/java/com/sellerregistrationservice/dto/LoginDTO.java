package com.sellerregistrationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

@AllArgsConstructor
public class LoginDTO {
	private String sellerEmailID;
	private String password;

}
