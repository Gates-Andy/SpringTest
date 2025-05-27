package com.andy.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.mvc.domain.Realtor;
import com.andy.test.mvc.repository.RealtorRepository;

@Service
public class RealtorService {
	@Autowired
	private RealtorRepository realtorRepository;
	//1.
	public int addRealtor(Realtor realtor) {
		int count = realtorRepository.insertRealtor(realtor);
		return count;
	}
	
	
}
