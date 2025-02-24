package com.shinnal.spring.test.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.thymeleaf.domain.Weather;
import com.shinnal.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	
	
	
	public int addWeather(Weather weather) {
		
		int count = weatherRepository.insertWeather(weather);
				
		return count;
	}
	
	public int addWeatherByObject(Weather weather) {
		
		int count = weatherRepository.insertWeatherByObject(weather);
		
		return count;
		
	}
	
	
	public List<Weather> getWeather() {
		
		List<Weather> weathers = weatherRepository.selectWeather();
		
		return weathers;
		
	}
	
	
}
