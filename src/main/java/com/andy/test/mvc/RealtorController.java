package com.andy.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andy.test.mvc.domain.Realtor;
import com.andy.test.mvc.service.RealtorService;

@Controller
@RequestMapping("/mvc/realtor")
public class RealtorController {
	@Autowired
	private RealtorService realtorService;

	// 1.
	@GetMapping("/create")
	public String creatRealtor(
			@RequestParam("office") String office, 
			@RequestParam("phoneNumber") String phonenumber,
			@RequestParam("address") String address, 
			@RequestParam("grade") String grade, 
			Model model) { // html에서 사용할 model 매게체

		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phonenumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);

		int count = realtorService.addRealtor(realtor);

		model.addAttribute("realtor", realtor);

		return "mvc/realtor/info";
	}
	
	@GetMapping("/input")
	public String realtorInput() {
		return "mvc/realtor/input";
	}
	
}
