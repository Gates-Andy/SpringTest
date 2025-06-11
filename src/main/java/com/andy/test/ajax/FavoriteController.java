package com.andy.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.test.ajax.domain.Favorite;
import com.andy.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;

	// 1 /ajax/favorite/list (GET) → 리스트 페이지 반환
	@GetMapping("/list")
	public String favoriteList(Model model) {

		List<Favorite> favoriteList = favoriteService.getFavoriteList();

		model.addAttribute("favoriteList", favoriteList);

		return "ajax/list";

	}

	// 2 즐겨찾기 추가 API /ajax/favorite/create (POST) → 즐겨찾기 추가 처리 (JSON 응답)
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createFavorite(@RequestParam("name") String name, @RequestParam("url") String url) {

		int count = favoriteService.addFavorite(name, url);

		Map<String, String> resultMap = new HashMap<>();

		if (count == 1) {
			resultMap.put("result", "success");

		} else {

			resultMap.put("result", "fail");

		}

		return resultMap;
	}

	// 3 templates/ajax/input.html
	@GetMapping("/input")
	public String inputFavoriteForm() {

		return "ajax/input";

	}

	@ResponseBody
	@PostMapping("/duplicate-url")
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {

		Map<String, Boolean> resultMap = new HashMap<>(); // 응답을 만들어주는 API를 json을 만들기위한 responsebody Map
		// 중복됨 : {"isDuplicate":true}
		// 중복안됨 :{"isDuplicate":false}

		if (favoriteService.isDuplicateUrl(url)) {

			// 중복됨
			resultMap.put("isDuplicate", true);

		} else {

			// 중복 안됨
			resultMap.put("isDuplicate", false);

		}
		return resultMap;
	}

	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		
		int count = favoriteService.deleteFavoriteById(id);

		Map<String, String> resultMap = new HashMap<>();

		if (count == 1) { // count의 개수가 지워졌다는건 1이라는 거임 0이 아니라
			resultMap.put("result", "success");
			
		} else {
			
			resultMap.put("result", "fail");
			
		}

		return resultMap;
	}
}