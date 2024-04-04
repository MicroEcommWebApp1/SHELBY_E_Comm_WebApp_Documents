package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


@Data

@Entity
@Table(name = "total_cart_price", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class TotalCartPrice {

	
	@Id
	private String email;
	private Long totalPrice;
	
}
