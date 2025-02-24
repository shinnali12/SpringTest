package com.shinnal.spring.test.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.mvc.domain.Realtor;
import com.shinnal.spring.test.thymeleaf.domain.Weather;
import com.shinnal.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	public Weather getWeather() {
		
		Weather weathers = weatherRepository.selectWeather();
		
		return weathers;
		
	}
	
	public int addWeather(Weather weather) {
		
		int count = weatherRepository.insertWeather(weather);
				
		return count;
	}
	
	
}
