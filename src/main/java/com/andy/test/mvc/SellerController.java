package com.andy.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andy.test.mvc.domain.Seller;
import com.andy.test.mvc.service.SellerService;

@Controller
public class SellerController {
	@Autowired
	private SellerService sellerService;

	@RequestMapping("/mvc/seller/info")
	public String SellerInfo(Model model) {
		Seller seller = sellerService.addSellerService();

		model.addAttribute("", "");
		model.addAttribute("", "");
		model.addAttribute("", "");

		return "mvc/sellerInfo";
	}
}
