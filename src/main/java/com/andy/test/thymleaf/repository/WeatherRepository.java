package com.andy.test.thymleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.andy.test.thymleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	public List<Weather> selectWheather();
}
