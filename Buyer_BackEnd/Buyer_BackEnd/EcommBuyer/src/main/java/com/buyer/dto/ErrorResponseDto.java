package com.buyer.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class ErrorResponseDto {
public String apiPath;
private HttpStatus errorCode;
private String errorMsg;
private LocalDateTime errorTime;


}