package com.buyer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.buyer.dto.BuyerDto;
import com.buyer.dto.LoginDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.buyer.entity.Buyer;

import com.buyer.repository.BuyerRepository;
import com.buyer.service.BuyerService;
import com.buyer.service.BuyerServiceImpl;
import com.buyer.service.EmailService;

@SpringBootTest
class EcommBuyerApplicationTests {

      @Test
      void context() {}
	
	/*@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BuyerServiceImpl buyerService;
	
	@Autowired
	private EmailService emailService;
	private  BuyerDto buyerDto;
	
	
	@BeforeEach
   public void setup() {
		 buyerDto = BuyerDto.builder()
				    .id(1)
				    .name("Swetha")
				    .email("swetha@gmail.com")
				    .password("swetha08!")
	                .phonenumber("9876543211")
	                .build();
	}
		
	@Test
    void testBuyerRegistration_SuccessfulRegistration() {
		
        when(buyerRepository.findByEmail("swetha333555@gmail.com")).thenReturn(null);
        
        // Mocking the behavior of modelMapper to return a Buyer object
        Buyer buyer = new Buyer();
        when(modelMapper.map(buyerDto, Buyer.class)).thenReturn(buyer);

        // Calling the buyerRegistration method
        ResponseEntity<?> response = buyerService.buyerRegistration(buyerDto);

        // Verifying that the buyer was saved and the welcome email was sent
        verify(buyerRepository).save(buyer);
        verify(emailService).sendSimpleEmail(eq("test@example.com"), anyString(), anyString());

        // Asserting the response status code and body
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Registered Successfully", response.getBody());
        

        when(buyerRepository.findByEmail(buyerDto.getEmail())).thenReturn(null);
        when(modelMapper.map(buyerDto, Buyer.class)).thenReturn(b1);

        // Act
        ResponseEntity<?> response = buyerService.buyerRegistration(buyerDto);

        // Assert
        verify(buyerRepository).findByEmail(buyerDto.getEmail());
        verify(modelMapper).map(buyerDto, Buyer.class);
        verify(buyerRepository).save(savedBuyer);
        verify(emailService).sendSimpleEmail(buyerDto.getEmail(), buyerDto.getName(), anyString());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Registered Successfully", response.getBody());
} 
	
	@Test
	    public void BuyerLogin_successtest() {
		  //  Buyer login = new Buyer();
	        // Mocking the buyerRepository behavior
	        when(buyerRepository.findByEmail(login.getEmail()).thenReturn(new Buyer);

	        // Calling the buyerLogin method with valid credentials
	      writ  ResponseEntity<?> response = buyerService.buyerLogin(new LoginDto("swetha333555@gmail.com", "password"));

	        // Asserting the response status code and body
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("Logged In", response.getBody());
	    }
*/
}

