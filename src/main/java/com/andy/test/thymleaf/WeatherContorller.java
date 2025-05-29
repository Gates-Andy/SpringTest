package com.andy.test.thymleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andy.test.thymleaf.domain.Weather;
import com.andy.test.thymleaf.service.WeatherService;

@Controller
@RequestMapping("/thymleaf/weather")
public class WeatherContorller {
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String watherList(Model model) {
		
		// 날씨 정보 리스트 얻어 오기
		List<Weather> weatherHistory = weatherService.getWeather();
		
		model.addAttribute("weatherHistory",weatherHistory);
		
		return "thymleaf/weather/list";
	}
	
	@GetMapping("/input")
	
	public String weatherInput() {
		
		return "thymleaf/weather/inupt";
		
	}
	
}
