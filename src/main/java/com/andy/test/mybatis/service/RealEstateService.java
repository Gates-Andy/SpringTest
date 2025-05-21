package com.andy.test.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.mybatis.domain.RealEstate;
import com.andy.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	@Autowired
	private RealEstateRepository realEstateRepository;

	public RealEstate getRealEstate(int id) {

		RealEstate realestate = realEstateRepository.selectRealEstate(id);

		return realestate;
	}
}
