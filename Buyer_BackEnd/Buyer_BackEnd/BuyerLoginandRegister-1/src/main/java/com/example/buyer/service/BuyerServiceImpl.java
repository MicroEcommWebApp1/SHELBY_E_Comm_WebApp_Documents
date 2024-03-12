package com.example.buyer.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buyer.entity.Buyer;
import com.example.buyer.entity.Login;
import com.example.buyer.repository.BuyerRepo;

@Service
public class BuyerServiceImpl implements BuyerService{
	
	@Autowired
	private BuyerRepo buyerrepo;

	@Override
	public String saveBuyer(Buyer buyer) {
		Buyer b1=buyerrepo.findByEmail(buyer.getEmail());
//		if("".equalsIgnoreCase(buyer.getName())) {
//			return "Pls enter name";
//		}
//		if("".equalsIgnoreCase(buyer.getEmail())) {
//			return "Pls enter email";
//		}
//		if("".equalsIgnoreCase(buyer.getPassword())) {
//			return "Pls enter password";
//		}
		if(b1 == null) {
		  buyerrepo.save(buyer);
		  return "success";
		}
		return "already registered";
	}

	@Override
	public String loginBuyer(Login login) {
		Buyer b2=buyerrepo.findByEmail(login.getEmail());
		if(b2 == null) {
			return "not registered";
		}
		if(b2.getPassword().equals(login.getPassword())) {
			return "logged in";
		}
		return "wrong password";
	}

	@Override
	public String resetPassword(String email,String password) {
		// TODO Auto-generated method stub
		Buyer b3=buyerrepo.findByEmail(email);
		if(b3 != null) {
			b3.setPassword(password);
			buyerrepo.save(b3);
			return "password reset done";
		}
		return "Please enter correct Emailid";
	}

}
