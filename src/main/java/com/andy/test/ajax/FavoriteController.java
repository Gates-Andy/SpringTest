package com.andy.test.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax/page")
public class FavoriteController {

	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> addPage(@RequestParam("name") String name, @RequestParam("url") String url) {

		Page page = new Page();
		page.setName(name);
		page.setUrl(url);

		int count = page.addPage(); 

		Map<String, String> resultMap = new HashMap<>();
		if (count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
		
	}
	
}
