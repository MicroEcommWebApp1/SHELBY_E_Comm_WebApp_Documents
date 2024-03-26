package com.SellerRegistrationservice.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponseDto {
	private String apiPath;
	private HttpStatus errorCode;
	private String errorMsg;
	private LocalDateTime errorTime;

}
