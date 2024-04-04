package com.paymentservice.model;

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
@Table(name = "Payment_table")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	@Id
	@SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq",initialValue=200, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
	private Long paymentId;
	private String name;
	private String email;
	private String address;
	private Long phoneNo;
	private Long totalCartValue;

}
