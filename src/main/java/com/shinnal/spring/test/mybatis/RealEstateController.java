package com.shinnal.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnal.spring.test.mybatis.domain.RealEstate;
import com.shinnal.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate/select")
public class RealEstateController {
	
//	1번 문제
	@Autowired
	private RealEstateService realEstateService;
	
	@ResponseBody
	@RequestMapping("/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
		
	}
	
//	2번 문제
	@ResponseBody
	@RequestMapping("/2")
	public List<RealEstate> realEstateRentPrice(@RequestParam("rentPrice") int rentPrice) {
		
		List<RealEstate> realEstate = realEstateService.getRealEstateRentPrice(rentPrice); 
		
		return realEstate;
	}
	
//	3번 문제
	
	@ResponseBody
	@RequestMapping("/3")
	public List<RealEstate> realEstateAreaPrice(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> realEstate = realEstateService.getRealEstateAreaPrice(area, price);
		
		return realEstate;
	}
	
	
	
	

}
