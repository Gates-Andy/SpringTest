package com.andy.test.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.test.ajax.domain.Favorite;
import com.andy.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/page")
public class FavoriteController {

	@Autowired
	private FavoriteService favoriteService;

	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> addPage(@RequestParam("name") String name, @RequestParam("url") String url) {
		Favorite favorite = new Favorite();
		favorite.setName(name);
		favorite.setUrl(url);

		int count = favoriteService.addFavorite(favorite);

		Map<String, String> resultMap = new HashMap<>();
		if (count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@GetMapping("/input")
	public String test01() {
		
		return "/ajax/input";
		
	}
	
}