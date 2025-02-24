package com.shinnal.spring.test.thymeleaf;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shinnal.spring.test.thymeleaf.domain.Weather;
import com.shinnal.spring.test.thymeleaf.service.WeatherService;


@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {

	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/create")
	public Object weatherCreate(
			@RequestParam("date") LocalDateTime date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed
			, Model model) {
		
		
		Weather weathers = new Weather();
		weathers.setDate(date);
		weathers.setWeather(weather);
		weathers.setTemperatures(temperatures);
		weathers.setPrecipitation(precipitation);
		weathers.setMicroDust(microDust);
		weathers.setWindSpeed(windSpeed);
		
		int count = weatherService.addWeather(weathers);
		
		model.addAttribute("weather", weathers);
		
		
		return "redirect:/thymeleaf/weather/info";
		
	}
	
	
	@GetMapping("/input")
	public Object weatherInput() {
		
		return "thymeleaf/WeatherInput";
	}
	
	
	@GetMapping("/info")
	public Object weatherInfo(Model model) {
		
		Weather weather = weatherService.getWeather();
	
		model.addAttribute("weather", weather);
		
		return "thymeleaf/WeatherInfo";
	}
			
	
}
