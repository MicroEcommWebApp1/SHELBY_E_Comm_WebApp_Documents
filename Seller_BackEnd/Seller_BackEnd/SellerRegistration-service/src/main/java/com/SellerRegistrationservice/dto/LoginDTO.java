package com.SellerRegistrationservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data

@AllArgsConstructor
public class LoginDTO {
	private String emailID;
	private String password;
	
}
