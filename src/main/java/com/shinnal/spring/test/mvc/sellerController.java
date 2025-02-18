package com.shinnal.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnal.spring.test.mvc.domain.Seller;
import com.shinnal.spring.test.mvc.service.SellerService;





@RequestMapping("/mvc/seller")
@Controller
public class sellerController {
	
	
	@Autowired
	private SellerService sellerService;
	
	// 1. 정보 전달 받고 저장!
	@ResponseBody
	@PostMapping("/create")
	public String sellerCreate(
			@RequestParam("nickname") String nickname
			, @RequestParam("temperature") double temperature
			, @RequestParam("profileImage") String profileImage) {
		
		int count = sellerService.addSeller(nickname, temperature, profileImage);
		
		return "삽입 결과: " + count;
		
	}
	
	// input 검색 화면
	@GetMapping("/input")
	public String inputSeller() {
		return "mvc/SellerInput";
	}
	
	// 2. info 검색 결과
	@GetMapping("/info")
	public String infoSeller(Model model) {
		
		Seller seller = sellerService.getLastSeller(); 
		
		model.addAttribute("seller", seller);
		
		return "mvc/SellerInfo";
	}
	
	
	
}
