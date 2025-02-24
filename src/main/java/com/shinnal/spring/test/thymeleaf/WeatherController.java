package com.shinnal.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnal.spring.test.thymeleaf.domain.Weather;
import com.shinnal.spring.test.thymeleaf.service.WeatherService;


@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {

	
	@Autowired
	private WeatherService weatherService;
	
//	@ResponseBody
	@GetMapping("/create")
	public String weatherCreate(
//			@DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures") double temperatures
//			, @RequestParam("precipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed
//			, Model model
			@ModelAttribute Weather weather) {
		
		
//		Weather weathers = new Weather();
//		weathers.setDate(date);
//		weathers.setWeather(weather);
//		weathers.setTemperatures(temperatures);
//		weathers.setPrecipitation(precipitation);
//		weathers.setMicroDust(microDust);
//		weathers.setWindSpeed(windSpeed);
		
//		int count = weatherService.addWeather(weathers);
		int count = weatherService.addWeatherByObject(weather);
		
//		model.addAttribute("weather", weather);
		
		
//		return "결과: " + count;
        return "redirect:/thymeleaf/weather/info";
		
	}
	
	
	@GetMapping("/input")
	public String weatherInput() {
		
		return "thymeleaf/WeatherInput";
	}
	
	
	@GetMapping("/info")
	public String weatherInfo(Model model) {
		
		List<Weather> weather = weatherService.getWeather();
	
		model.addAttribute("weather", weather);
		
		return "thymeleaf/WeatherInfo";
	}
			
	
}
