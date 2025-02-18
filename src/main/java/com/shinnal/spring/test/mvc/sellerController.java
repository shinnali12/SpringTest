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
//	@ResponseBody  // ResponseBody가 있으면 리턴받는 값을 그대로 출력해줌!!!!
	@PostMapping("/create") // RequestMapping -> Post or Get으로 html(입력)과 연결. 
	public String sellerCreate(
			@RequestParam("nickname") String nickname
			, @RequestParam("temperature") double temperature
			, @RequestParam("profileImage") String profileImage) {
		
		int count = sellerService.addSeller(nickname, temperature, profileImage);
		
//		sendRedirect(""); 다시 요청 - 결과페이지로 요청
		return "redirect:/mvc/seller/info";
		
//		return "삽입 결과: " + count; // 추가한 정보에 대한 갯수 확인
		
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
		
		model.addAttribute("seller", seller); // 모델에 멤버변수를 담아 html에서 꺼내쓸 수 있게 한다!!! ("키", 변수)
		
		return "mvc/SellerInfo";
	}
	
	// 3. id 파라미터 받아 결과 출력 / 없는 경우 처리가 가능하도록!!
	
	@GetMapping("/infoparam")
	public String sellerSelect(@RequestParam("id")int id, Model model) {
		
		Seller seller = sellerService.getSeller(id);
		
		model.addAttribute("seller", seller);
		
		return "mvc/SellerInfo";
	}
	
	
}
