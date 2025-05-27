package com.andy.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.mvc.domain.Seller;
import com.andy.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;

	public int addSellerService(String nickname ,double temperature ,String profileImage) {
		int count = sellerRepository.insertSellerUser(nickname, temperature, profileImage);
		return count;
	}
	
	public Seller getLastSeller() {
		Seller seller = sellerRepository.selectLastSeller();
		return seller;
	}
	
	public Seller getSeller(int id) {
		Seller seller = sellerRepository.selectSeller(id);
		return seller;
	}
	
}


