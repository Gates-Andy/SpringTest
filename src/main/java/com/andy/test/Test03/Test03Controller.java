package com.andy.test.Test03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {
	
	@RequestMapping("/lifecycle/test03/1")
	public String thymleafResponse() {
		
		return "lifecycle/Test03";
		
	}
	
}
