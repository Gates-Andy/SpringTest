package com.andy.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.test.mybatis.domain.RealEstate;
import com.andy.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {
	@Autowired
	private RealEstateService realEstateService; // service 변수 가져오기위해 service 객체 변수 만들고

	@ResponseBody
	@RequestMapping("/select/1")
	public RealEstate realEstate(@RequestParam("id") int id) { // 리턴타입은 entity 클래스이고 responseBody를 사용하여 JSON
		// 작성한 realEstate 메서드는 @RequestParam("id")를 통해 HTTP 요청 파라미터로부터 id 값을 받아서 사용
		// @RequestParam은 HTTP 요청의 파라미터 값을 자바 메서드의 파라미터로 매핑해주는 Spring의 애노테이션.

		RealEstate realEstate = realEstateService.getRealEstate(id);

		return realEstate;
	}

	@ResponseBody
	@RequestMapping("/select/2")
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rentPrice") int rentPrice) {

		List<RealEstate> realEstateList = realEstateService.getRealEstateByRentPrice(rentPrice);

		return realEstateList;
	}

	@RequestMapping("/select/3")
	public List<RealEstate> realEstateByAreaAndPrice(@RequestParam("area") int area, @RequestParam("price") int price) {

		List<RealEstate> realEstateList = realEstateService.getRealEstateByAreaAndPrice(area, price);

		return realEstateList;
	}

	@RequestMapping("/insert/1")
	public String createRealEstateByObject() {
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);

		int count = realEstateService.addRealEstateByObject(realEstate);

		return "실행 결과 :" + count;
	}

}
