package com.shinnal.spring.test.thymeleaf.repository;

import org.apache.ibatis.annotations.Mapper;

import com.shinnal.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface WeatherRepository {

	public Weather selectWeather();
	
	public int insertWeather(Weather weather);
	
	
}


