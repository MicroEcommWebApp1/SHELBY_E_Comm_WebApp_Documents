package com.example.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Order_table")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
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
