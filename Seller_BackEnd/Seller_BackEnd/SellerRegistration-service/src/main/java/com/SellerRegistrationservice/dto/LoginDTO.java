package com.SellerRegistrationservice.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LoginDTO {
	private String emailID;
	private String password;
	
	@CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updated_at;
	
}
