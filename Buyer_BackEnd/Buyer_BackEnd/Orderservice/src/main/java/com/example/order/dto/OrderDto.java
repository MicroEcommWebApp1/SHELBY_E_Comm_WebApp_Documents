package com.example.order.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private Long orderId;
	private Long productId;
	private Long paymentId;
		
		private String buyerName;
		
		private String email;
		
		private String address;
		
		private Long phoneNo;
		
		private String productName;


		private String description;

		private String thumbnail;

		
		private double price;

		
		private int quantity;


		private String category;


		private String subcategory1;

		
		private String subcategory2;
		
		private Long totalAmount;
		private Long totalproductPrice;
		private String status;


}
