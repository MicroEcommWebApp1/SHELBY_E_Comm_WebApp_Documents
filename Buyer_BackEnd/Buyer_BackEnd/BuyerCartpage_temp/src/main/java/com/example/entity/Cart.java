package com.example.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
    private Long productId;

	private String email;

	@Column(nullable = false)
	private String name;

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

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	    
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;


}
