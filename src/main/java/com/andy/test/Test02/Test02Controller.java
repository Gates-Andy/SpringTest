package com.andy.test.Test02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {

	@RequestMapping("/1")
	public List<Map<String, Object>> listMapResponse() {

		List<Map<String, Object>> movieList = new ArrayList<>();

		Map<String, Object> movie1 = new HashMap<>();
		movie1.put("rate", 15);
		movie1.put("director", "봉준호");
		movie1.put("time", 131);
		movie1.put("title", "기생충");

		Map<String, Object> movie2 = new HashMap<>();
		movie2.put("rate", 0);
		movie2.put("director", "로베르토 베니니");
		movie2.put("time", 116);
		movie2.put("title", "인생은 아름다워");

		Map<String, Object> movie3 = new HashMap<>();
		movie3.put("rate", 12);
		movie3.put("director", "Christopher Nolan");
		movie3.put("time", 147);
		movie3.put("title", "Inception");

		Map<String, Object> movie4 = new HashMap<>();
		movie4.put("rate", 19);
		movie4.put("director", "윤종빈");
		movie4.put("time", 133);
		movie4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");

		Map<String, Object> movie5 = new HashMap<>();
		movie5.put("rate", 15);
		movie5.put("director", "Francis Lawrence");
		movie5.put("time", 137);
		movie5.put("title", "Hunger Game");

		movieList.add(movie1);
		movieList.add(movie2);
		movieList.add(movie3);
		movieList.add(movie4);
		movieList.add(movie5);
		
		// movie1 = new HashMap<>(); 를 계속 사용해서 해도된다. heap영역 add로서 list에 넣어진 뒤 사라짐
		return movieList;
	}

	@RequestMapping("/2") 
	public List<Test02userBoard> userBoardResponse() {
		Test02userBoard userBoard1 = new Test02userBoard("안녕하세요 가입인사 드립니다.", "hangulu",
				"안녕하세요 가입했어요 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		Test02userBoard userBoard2 = new Test02userBoard("헐 대박", "bada", "오늘 목요일이였어... 금요일인줄");
		Test02userBoard userBoard3 = new Test02userBoard("오늘 데이트 한 이야기 해드릴게요", "dulumary", "...");
		return Arrays.asList(userBoard1, userBoard2, userBoard3);
	}
	
//	@RequestMapping("/lifecycle/test02/2") 
//	public List<Post> listObjectResponse() {
//		
//		List<Post> postList = new ArrayList<>();
//		
//		Post post = new Post("안녕하세요 가입인사 드립니다.", "hangulu",
//				"안녕하세요 가입했어요 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
//		postList.add(post);
//		
//		postList.add(new("","",""));
//		postList.add(new("","",""));
//	
//		return postList;
//	}
	
	@RequestMapping("/3") 
	public ResponseEntity<Post> entutyResponse(){
		Post post = new Post("안녕하세요 가입인사 드립니다.", "hangulu","안녕하세요 가입했어요 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		ResponseEntity entity = new ResponseEntity<>(post,HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
}
