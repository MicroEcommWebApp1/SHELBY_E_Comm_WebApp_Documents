package com.sellerregistrationservice.service;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sellerregistrationservice.dto.LoginDTO;
import com.sellerregistrationservice.dto.SellerRegistrationDTO;
import com.sellerregistrationservice.model.SellerRegistration;
import com.sellerregistrationservice.repository.SellerRegistrationRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SellerRegistrationServiceImpl implements SellerRegistrationService {
	private final SellerRegistrationRepo sellerRegistrationRepo;
	private final ModelMapper modelMapper;
	private final EmailSenderService sendemail;

	@Override
	public SellerRegistrationDTO createSellerRegistration(SellerRegistrationDTO sellerRegistrationDTO) {
		if (existsByEmailID(sellerRegistrationDTO.getSellerEmailID())) {
			throw new IllegalArgumentException("Email ID already exists");
		}

		SellerRegistration createdSellerRegistration = sellerRegistrationRepo
				.save(modelMapper.map(sellerRegistrationDTO, SellerRegistration.class));

		sendemail.sendEmailWithAttachment(sellerRegistrationDTO.getSellerEmailID(), "welcome to shellby app",
				sellerRegistrationDTO.getName());
		return modelMapper.map(createdSellerRegistration, SellerRegistrationDTO.class);
	}

	@Override
	public List<SellerRegistrationDTO> getAllSellerRegistrations() {
		List<SellerRegistration> sellerRegistrations = sellerRegistrationRepo.findAll();
		return sellerRegistrations.stream()
				.map(sellerRegistration -> modelMapper.map(sellerRegistration, SellerRegistrationDTO.class)).toList();
	}

	@Override
	public boolean validateLogin(LoginDTO loginRequest) {
		String emailID = loginRequest.getSellerEmailID();
		String password = loginRequest.getPassword();
		SellerRegistration seller = sellerRegistrationRepo.findBySellerEmailID(emailID);
		return seller != null && seller.getPassword().equals(password);
	}

	@Override
	public boolean existsByEmailID(String emailID) {
		return sellerRegistrationRepo.existsBySellerEmailID(emailID);
	}

	@Override
	public ResponseEntity<String> forgotPassword(String email) {
		SellerRegistration seller = sellerRegistrationRepo.findBySellerEmailID(email);
		if (seller != null) {
			sendemail.sendSimpleEmail(seller.getSellerEmailID(),
					seller.getName() + " Your password is " + seller.getPassword(),
					"Welcome to our E-Comm Application");
			return new ResponseEntity<>("Password sent to email", HttpStatus.OK);
		}
		return new ResponseEntity<>("Not a valid email", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateProfile(SellerRegistrationDTO profiledto) {
		SellerRegistration seller = sellerRegistrationRepo.findBySellerEmailID(profiledto.getSellerEmailID());

		seller.setCompanyAddress(profiledto.getCompanyAddress());
		seller.setPhoneNumber(profiledto.getPhoneNumber());
		sellerRegistrationRepo.save(seller);
		return new ResponseEntity<>("successfully updated", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> getbyid(Long id) {

		SellerRegistration details = sellerRegistrationRepo.findById(id);

		if (details != null) {

			return new ResponseEntity<>(details, HttpStatus.OK);
		} else {

			return new ResponseEntity<>("Details not found for ID: " + id, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<SellerRegistrationDTO> getSellerDetailsByEmail(String emailID) {
		SellerRegistration seller = sellerRegistrationRepo.findBySellerEmailID(emailID);
		if (seller != null) {
			SellerRegistrationDTO sellerDto = modelMapper.map(seller, SellerRegistrationDTO.class);
			return Collections.singletonList(sellerDto);
		} else {
			return Collections.emptyList();
		}
	}
	@Override
	public int getSellerCount() {
		List<SellerRegistration> seller=sellerRegistrationRepo.findAll();
		
		return seller.size();
	}
}
