package com.andy.test.thymleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymleafController {

	@GetMapping("/thymleaf/test01")
	public String test01() {
		return "thymleaf/test01";
	}
	
	
}
