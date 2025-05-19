package com.andy.test.Test02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test02Controller {
	@RequestMapping("/lifecycle/test02/1")

	public List<Map<String, Object>> listResponse() {

		List<Map<String, Object>> mapList = new ArrayList<>();

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

		mapList.add(movie1);
		mapList.add(movie2);
		mapList.add(movie3);
		mapList.add(movie4);
		mapList.add(movie5);

		return mapList;
	}
}
