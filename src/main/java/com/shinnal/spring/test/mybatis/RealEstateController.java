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
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {
	
//	1번 문제
	@Autowired
	private RealEstateService realEstateService;
	
	@ResponseBody
	@RequestMapping("/select/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
		
	}
	
//	2번 문제
	@ResponseBody
	@RequestMapping("/select/2")
	public List<RealEstate> realEstateRentPrice(@RequestParam("rentPrice") int rentPrice) {
		
		List<RealEstate> realEstate = realEstateService.getRealEstateRentPrice(rentPrice); 
		
		return realEstate;
	}
	
//	3번 문제
	
	@ResponseBody
	@RequestMapping("/select/3")
	public List<RealEstate> realEstateAreaPrice(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> realEstate = realEstateService.getRealEstateAreaPrice(area, price);
		
		return realEstate;
	}
	
	
// insert 쿼리 1
	@ResponseBody
	@RequestMapping("/insert/1")
	public String realEstateCreate() { // 직접 객체정보를 입력하니까 controller에서 객체에 대한 내용 입력!!
		
//		realtorId : 3
//		address : 푸르지용 리버 303동 1104호
//		area : 89
//		type : 매매
//		price : 100000
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3); 
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		
		int count = realEstateService.addRealEstateCreate(realEstate);
		
		return "입력 성공 : " + count;
		
	}
	
	
// insert 쿼리 2
	
	@ResponseBody
	@RequestMapping("/insert/2")
	public String realEstateObject(@RequestParam("realtorId") int realtorId) {
		// insert로 추가 하는 거니까 파라미터입력값으로 넣어주면 됨
		
		int count = realEstateService.addRealEstateObject(realtorId, "쌍떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;
				
		
	}
	
	
//	update 쿼리
	
	public String realEstateUpdate() {
		
		
	}
	

}
