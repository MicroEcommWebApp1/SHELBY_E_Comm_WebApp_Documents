package com.buyer.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseDto {
private String statusCode;
private String statusMsg;


}