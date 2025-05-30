package com.andy.test.thymleaf;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andy.test.thymleaf.domain.Weather;
import com.andy.test.thymleaf.service.WeatherService;

@Controller
@RequestMapping("/thymleaf/weather")
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	//1 List Model로 가져오기
	@GetMapping("/list")
	public String weatherList(Model model) {
		List<Weather> weatherHistory = weatherService.getWeather();
		model.addAttribute("weatherHistory", weatherHistory);
		return "thymleaf/list";
	}
	
	@PostMapping("/add")
	public String addWeather(
	    @RequestParam("date") LocalDateTime date,
	    @RequestParam("weather") String weather,
	    @RequestParam("temperatures") double temperatures,
	    @RequestParam("precipitation") double precipitation,
	    @RequestParam("microDust") String microDust,
	    @RequestParam("windSpeed") double windSpeed) {
	    
	    Weather newWeather = new Weather();
	    newWeather.setDate(date);
	    newWeather.setWeather(weather);
	    newWeather.setTemperatures(temperatures);
	    newWeather.setPrecipitation(precipitation);
	    newWeather.setMicroDust(microDust);
	    newWeather.setWindSpeed(windSpeed);

	    weatherService.addWeather(newWeather);

	    return "redirect:/thymleaf/list";
	}

}
