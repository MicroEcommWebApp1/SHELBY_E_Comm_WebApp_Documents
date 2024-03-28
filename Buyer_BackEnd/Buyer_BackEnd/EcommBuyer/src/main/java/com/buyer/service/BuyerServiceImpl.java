package com.buyer.service;

import java.util.Collections;
import java.util.List;

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
public class BuyerServiceImpl implements BuyerService {

	private final BuyerRepository buyerRepository;
	private final ModelMapper modelMapper;
	private final EmailService emailService;

	@Autowired
	public BuyerServiceImpl(BuyerRepository buyerRepository, ModelMapper modelMapper, EmailService emailService) {
		this.buyerRepository = buyerRepository;
		this.modelMapper = modelMapper;
		this.emailService = emailService;
	}

	@Override
	public ResponseEntity<String> buyerRegistration(BuyerDto buyerDto) {
		Buyer b1 = buyerRepository.findByEmail(buyerDto.getEmail());

		if (b1 == null) {
			Buyer b2 = this.modelMapper.map(buyerDto, Buyer.class);
			buyerRepository.save(b2);

			emailService.sendEmailWithAttachment(buyerDto.getEmail(), "welcome to shellby app", buyerDto.getName());
			return new ResponseEntity<>("Registered Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("already exists", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> buyerLogin(LoginDto login) {
		Buyer b3 = buyerRepository.findByEmail(login.getEmail());
		if (b3 == null) {
			return new ResponseEntity<>("{\"message\": \"Not a registered email\"}", HttpStatus.BAD_REQUEST);
		}
		if (b3.getPassword().equals(login.getPassword())) {
			return new ResponseEntity<>("{\"message\": \"Logged In\"}", HttpStatus.OK);
		}
		return new ResponseEntity<>("{\"message\": \"Incorrect Password\"}", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> update(BuyerDto buyerDto) {
		Buyer b4 = buyerRepository.findByEmail(buyerDto.getEmail());
		b4.setPhonenumber(buyerDto.getPhonenumber());
		buyerRepository.save(b4);
		return new ResponseEntity<>("Successfully updated", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> getPasswordtoemail(String email) {

		Buyer buyer = buyerRepository.findByEmail(email);
		if (buyer != null) {
			emailService.sendSimpleEmail(email, buyer.getPassword() + "is your registered password ",
					"Welcome to our E-Comm Application");
			return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"EmailID sent\"}");
		}
		return new ResponseEntity<>("Email not found", HttpStatus.BAD_REQUEST);
	}

	@Override
	public List<BuyerDto> getAllBuyerDetails() {
		List<Buyer> buyerlist = buyerRepository.findAll();
		if (!buyerlist.isEmpty())
			return buyerlist.stream().map(buyer -> modelMapper.map(buyer, BuyerDto.class)).toList();
		else
			return null;

	}

	@Override
	public List<BuyerDto> getBuyerdetailsByEmail(String email) {
		Buyer buyer = buyerRepository.findByEmail(email);
		if (buyer != null) {
			BuyerDto buyerDto = modelMapper.map(buyer, BuyerDto.class);
			return Collections.singletonList(buyerDto);
		} else {
			return Collections.emptyList();
		}
	}

}
