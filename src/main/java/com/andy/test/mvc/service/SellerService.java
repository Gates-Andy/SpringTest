package com.andy.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.mvc.domain.Seller;
import com.andy.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	
	public Seller addSellerService() {
		Seller seller = sellerRepository.selectSellerUser();
		
		return seller;
	}
}
