package com.andy.test.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.test.mybatis.domain.RealEstate;
import com.andy.test.mybatis.service.RealEstateService;

@Controller
public class RealEstateController {
	@Autowired
	private RealEstateService realEstateService;
	
	@ResponseBody
	@RequestMapping("/mybatis/real-estate/select/1")
	public RealEstate realEstate(@RequestParam("id")int id){
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
}
