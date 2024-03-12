
package com.SellerRegistrationservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SellerRegistrationservice.dto.LoginDTO;
import com.SellerRegistrationservice.dto.SellerRegistrationDTO;
import com.SellerRegistrationservice.model.SellerRegistration;
import com.SellerRegistrationservice.repository.SellerRegistrationRepo;

@Service
public class SellerRegistrationServiceImpl implements SellerRegistrationService {
	private final SellerRegistrationRepo sellerRegistrationRepo;
	private final ModelMapper modelMapper;

	@Autowired
	public SellerRegistrationServiceImpl(SellerRegistrationRepo sellerRegistrationRepo, ModelMapper modelMapper) {
		this.sellerRegistrationRepo = sellerRegistrationRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public SellerRegistrationDTO createSellerRegistration(SellerRegistrationDTO sellerRegistrationDTO) {
		SellerRegistration createdSellerRegistration = sellerRegistrationRepo
				.save(modelMapper.map(sellerRegistrationDTO, SellerRegistration.class));
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
}
