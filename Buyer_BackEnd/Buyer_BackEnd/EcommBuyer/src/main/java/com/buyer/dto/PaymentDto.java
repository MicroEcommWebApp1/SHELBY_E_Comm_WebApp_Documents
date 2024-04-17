package com.buyer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	private Long paymentId;
	private String name;
	private String email;
	private String address;
	private Long phoneNo;
	private Long totalCartValue;

}
