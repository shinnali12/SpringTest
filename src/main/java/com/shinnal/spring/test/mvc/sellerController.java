package com.shinnal.spring.test.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sellerController {
	
	@ResponseBody
	@PostMapping()
	public String sellerCreate(
			@RequestParam("id") int id
			, @RequestParam("nickname") String nickname
			, @RequestParam("temperature") double temperature
			, @RequestParam("profileImage") String profileImage) {
		
		
	}
	
}
