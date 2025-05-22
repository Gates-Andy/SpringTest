package com.andy.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.mybatis.domain.RealEstate;
import com.andy.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	@Autowired
	private RealEstateRepository realEstateRepository; // 맴버변수를 통해서 객체변수를 만들고

	public RealEstate getRealEstate(int id) {
//		getRealEstate(int id) Controller로부터 받은 id를 바탕으로, Repository에 있는 selectRealEstate(id)를 호출하여 DB에서 데이터를 가져오고,
//		가져온 RealEstate 객체를 Controller에게 반환합니다.

		RealEstate realEstate = realEstateRepository.selectRealEstate(id); // 인자 전달

		return realEstate;
	}

	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateByRentPrice(rentPrice);
		
		return realEstateList;
	}
	
	public List<RealEstate> getRealEstateByAreaAndPrice(int area, int price){
		
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateByAreaAndPrice(area, price);
		
		return realEstateList;
		
	}
	
	public int addRealEstateByObject(RealEstate realEstate) {
		
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		
		return count;
		
	}
	
}
