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
	@Id
	@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", initialValue = 200, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	private Long orderId;
	
	private String buyerName;
	
	private String email;
	
	private String address;
	
	private Long phoneNo;
	
	@Column(nullable = false)
	private String productName;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String thumbnail;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private String category;

	@Column(name = "sub_cat1")
	private String subcategory1;

	@Column(name = "sub_cat2")
	private String subcategory2;
	
	private Long totalAmount;
	
	private String status;

}
