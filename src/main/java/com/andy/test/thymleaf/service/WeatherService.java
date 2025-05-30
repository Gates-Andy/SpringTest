package com.andy.test.thymleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.thymleaf.domain.Weather;
import com.andy.test.thymleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;
	
	//1. 모든 날씨 정보 리스트 얻어오기	
	public List<Weather> getWeather(){
		List<Weather> weather = weatherRepository.selectWeather();
		return weather;
	}
	
	public void addWeather(Weather weather) {
	    weatherRepository.insertWeather(weather);
	}
	
}

