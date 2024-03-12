package com.buyer.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.buyer.dto.BuyerDto;
import com.buyer.dto.LoginDto;
import com.buyer.entity.Buyer;
import com.buyer.repository.BuyerRepository;

@Service
public class BuyerServiceImpl implements BuyerService{
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> buyerRegistration(BuyerDto buyerDto) {
		Buyer b1=buyerRepository.findByEmail(buyerDto.getEmail());
		Buyer b2=this.modelMapper.map(buyerDto,Buyer.class);
		if(b1 == null) {
			return new ResponseEntity<>(buyerRepository.save(b2),HttpStatus.OK);
		}
		return new ResponseEntity<>("already exits",HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> buyerLogin(LoginDto login) {
		Buyer b3=buyerRepository.findByEmail(login.getEmail());
		if(b3 == null) {
			return new ResponseEntity<>("Not a registered email",HttpStatus.BAD_REQUEST);
		}
		if(b3.getPassword().equals(login.getPassword())) {
			return new ResponseEntity<>("Logged In",HttpStatus.OK);
		}
		return new ResponseEntity<>("Incorrect Password",HttpStatus.BAD_REQUEST);
		
	}

	@Override
	public ResponseEntity<?> forgotPassword(String email,String password) {
		Buyer b4=buyerRepository.findByEmail(email);
		if(b4 != null) {
			b4.setPassword(password);
			buyerRepository.save(b4);
			return new ResponseEntity<>("Password Reset Done",HttpStatus.OK);
		}
		return new ResponseEntity<>("Account Not Found",HttpStatus.BAD_REQUEST);
	}

}
