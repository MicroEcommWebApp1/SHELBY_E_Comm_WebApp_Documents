package com.buyer.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.buyer.dto.BuyerDto;
import com.buyer.entity.Buyer;
import com.buyer.repository.BuyerRepository;

public class BuyerServiceTest {
	
	@Autowired
	private BuyerServiceImpl buyerServiceImpl;
	
	//@Autowired
//	private ModelMapper modelMapper;
	
//	@Autowired
//	private EmailService email;
	
	@MockBean
	private BuyerRepository buyerRepository;
	
	//private BuyerDto buyerDto;
	
	/*@BeforeEach
	public void setup() {
	// buyerDto = BuyerDto.builder()
			 .id(1)
			 .name("Swetha")
			 .email("swetha@gmail.com")
			 .password("swetha08!")
			 .phonenumber("9876543211")
			 .build();
	}
	
	@Test
	public void test_BuyerRegistration() {
	//	Buyer savedbuyer = buyerRepository.findByEmail(buyerDto.getEmail());
      //  when(modelMapper.map(buyerDto, Buyer.class)).thenReturn(savedBuyer);
	}
*/
}
