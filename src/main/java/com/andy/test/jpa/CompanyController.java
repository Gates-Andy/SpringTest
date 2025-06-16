package com.andy.test.jpa;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.test.jpa.domain.Company;
import com.andy.test.jpa.service.CompanyService;

@Controller
@RequestMapping("/jpa")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@ResponseBody
	@GetMapping("/create")
	public List<Company> createCompany() {

		Company nexon = companyService.addCompany(1,"넥손","컨텐츠 게임","대기업",3585);
		Company bubble = companyService.addCompany(2,"버블팡","여신 금융업","대기업",6934);

		return Arrays.asList(nexon,bubble);

	}
	
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		
		// id가 2인 회사 scale을 중소기업으로 변경 headcount를 34로변경
		
		Company company = companyService.updateCompany(2,"중소기업",34);
		
		return company;
		
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany(int id) {
		
		companyService.deleteCompany(1);
		
		return "수행 완료";
		
	}
	
}
