package com.chatservice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long ticketID;
	private String email;
	private String name;
	private String description;
	@CreationTimestamp

	@Column(name = "createdAt", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp

	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;

}
