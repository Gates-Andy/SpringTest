package com.andy.test.lifecycle.Test03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {
	
	@RequestMapping("/lifecycle/test03/1") // 요청(request)이 들어오면
	public String thymleafResponse() {
		//	이 문자열은 resources/templates/lifecycle/Test03.html 파일을 뜻합니다.
		// "lifecycle/Test03" 라는 Thymeleaf 템플릿(templates html 공통 작성 생략) 파일을 찾아서 보여줘요
		return "lifecycle/Test03";
		// 정적인 html 파일만 보여주는데 thymeleaf 탬플릿 문법 th:text 등을 사용해서 동적인 데이터까지 출력을 할 수 있다.
	}
	
}
