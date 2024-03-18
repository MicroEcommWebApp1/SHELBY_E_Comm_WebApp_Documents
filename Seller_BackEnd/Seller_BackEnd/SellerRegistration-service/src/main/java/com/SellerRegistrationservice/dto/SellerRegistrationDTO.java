package com.SellerRegistrationservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerRegistrationDTO {
	private int id;
	private String name;
	@NotEmpty
	@Pattern(regexp = ".*@gmail\\.com$",message="Email must contain @gmail.com")
	private String emailID;
	private String companyName;
	@Pattern(regexp="^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$", message="GST number should contain unique 15 alphanumeric")
	private String gstNumber;
	private String companyAddress;
	@Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number must have 10 digits")
	private String phoneNumber;
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{8,}$" , message="password should contain min 8 characters with alphabets,numeric and special character ")
	private String password;
	
	@CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updated_at;
	
}