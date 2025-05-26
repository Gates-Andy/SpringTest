package com.andy.test.lifecycle.Test03;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03ThymleafController {
	@RequestMapping("/lifecycle/test03/thymleaf")
	public String thymleafResponse(Model model) {
		//	Spring MVC에서 컨트롤러에서 HTML로 값을 전달하고 싶을 때 사용하는 도구입니다.
		//	쉽게 말하면: model은 백엔드(Java) → 프론트엔드(HTML) 에 데이터를 넘기는 가방 같은 것!
		
	    List<String> menuList = Arrays.asList("스테이크", "연어", "햄버거");
	    
	    model.addAttribute("menus", menuList);
	    //	model.addAttribute("이름", 값) 이렇게 쓰면,
	    
	    //	"이름": HTML에서 사용할 이름 (예: ${menus})
	    //	값: 전달할 실제 값 (문자열, 숫자, 리스트, 객체 등)
	    
	    return "/lifecycle/Test03Thymleaf";
	    
	}
	
}
