package com.andy.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andy.test.mvc.domain.Seller;
import com.andy.test.mvc.service.SellerService;

@Controller
@RequestMapping("/mvc/seller") // **0
public class SellerController {
	@Autowired
	private SellerService sellerService;

	// 하나의 판매자 정보 저장 기능 : 닉네임, 매너온도, 프로필url
	// @ResponseBody
	// @RequestMapping(path="/mvc/seller/create", method=RequestMethod.POST) 
	// 메소드 형식은 기본적으로 method=RequestMethod.GET 입니다. 하지만 이제는 아래에
	@PostMapping("/create") // **1 post mapping을 form 태그 action create으로 input html 소화시킬 수 밖에 없다.
	public String createSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam("temperature") double temperature, 
			@RequestParam("profileImage") String profileImage) {
			// 필수 파라미터
		int count = sellerService.addSellerService(nickname, temperature, profileImage);
		//return "실행 결과 :" + count; 보다는 아래에 리턴 페이지
		return "redirect:/mvc/seller/info";
	}
	
	//2. getMapping은 파라미터가 없고 보여주기식이다. input 한 자료들을 return하여 보여준다.
	@GetMapping("/input") // **2
	public String sellerInput() {
		return "mvc/seller/input";
	}
	
	//3. getMapping은 파라미터가 없고 보여주기식이다. input 한 자료들을 return하여 보여준다.
	@GetMapping("/info") // **2
	public String sellerInfo(@RequestParam(value="id", required=false) Integer id, Model model) {
		// 필수 파라미터가아닌 id 그래서 추가적인 설정이 필요 @RequestParam(value="id", required= chage true to false)
		Seller seller = null; // 변수 만들고 지역변수로 조건문 위에 배치
		if(id == null) {
			seller = sellerService.getLastSeller();
		} else {
			seller = sellerService.getSeller(id);
		}
		model.addAttribute("seller",seller);
		return "mvc/seller/information";

	}
	

}
