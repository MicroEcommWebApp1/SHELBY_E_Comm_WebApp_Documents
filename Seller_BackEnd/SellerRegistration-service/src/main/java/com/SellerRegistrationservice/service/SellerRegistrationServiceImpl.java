
package com.SellerRegistrationservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SellerRegistrationservice.dto.LoginDTO;
import com.SellerRegistrationservice.dto.SellerRegistrationDTO;
import com.SellerRegistrationservice.model.SellerRegistration;
import com.SellerRegistrationservice.repository.SellerRegistrationRepo;

@Service
public class SellerRegistrationServiceImpl implements SellerRegistrationService {
	private final SellerRegistrationRepo sellerRegistrationRepo;
	private final ModelMapper modelMapper;
	private final EmailSenderService sendemail;

	public SellerRegistrationServiceImpl(SellerRegistrationRepo sellerRegistrationRepo, ModelMapper modelMapper,
			EmailSenderService sendemail) {
		this.sellerRegistrationRepo = sellerRegistrationRepo;
		this.modelMapper = modelMapper;
		this.sendemail = sendemail;
	}

	@Override
	public SellerRegistrationDTO createSellerRegistration(SellerRegistrationDTO sellerRegistrationDTO) {
		if (existsByEmailID(sellerRegistrationDTO.getEmailID())) {
			throw new IllegalArgumentException("Email ID already exists");
		}

		SellerRegistration createdSellerRegistration = sellerRegistrationRepo
				.save(modelMapper.map(sellerRegistrationDTO, SellerRegistration.class));

		sendemail.sendEmailWithAttachment(sellerRegistrationDTO.getEmailID(), "welcome to shellby app",
				sellerRegistrationDTO.getName());
		return modelMapper.map(createdSellerRegistration, SellerRegistrationDTO.class);
	}

	@Override
	public List<SellerRegistrationDTO> getAllSellerRegistrations() {
		List<SellerRegistration> sellerRegistrations = sellerRegistrationRepo.findAll();
		return sellerRegistrations.stream()
				.map(sellerRegistration -> modelMapper.map(sellerRegistration, SellerRegistrationDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public boolean validateLogin(LoginDTO loginRequest) {
		String emailID = loginRequest.getEmailID();
		String password = loginRequest.getPassword();
		SellerRegistration seller = sellerRegistrationRepo.findByEmailID(emailID);
		return seller != null && seller.getPassword().equals(password);
	}

	@Override
	public boolean existsByEmailID(String emailID) {
		return sellerRegistrationRepo.existsByEmailID(emailID);
	}

	@Override
	public ResponseEntity<?> forgotPassword(String email) {
		SellerRegistration seller = sellerRegistrationRepo.findByEmailID(email);
		if (seller != null) {
			sendemail.sendSimpleEmail(seller.getEmailID(),
					seller.getName() + " Your password is " + seller.getPassword(),
					"Welcome to our E-Comm Application");
			return new ResponseEntity<>("Password sent to email", HttpStatus.OK);
		}
		return new ResponseEntity<>("Not a valid email", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateProfile(SellerRegistrationDTO profiledto) {
		SellerRegistration seller = sellerRegistrationRepo.findByEmailID(profiledto.getEmailID());

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

}
