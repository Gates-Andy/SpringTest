package com.andy.test.thymleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.andy.test.thymleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	//1
	public List<Weather> selectWeather();
    
	public int insertWeather(Weather weather);
	
}