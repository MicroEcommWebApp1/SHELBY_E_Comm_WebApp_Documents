package com.example.buyer.service;

import com.example.buyer.entity.Buyer;
import com.example.buyer.entity.Login;

public interface BuyerService {

	public String saveBuyer(Buyer buyer);

	public String loginBuyer(Login login);

	public String resetPassword(String email,String password);

}
