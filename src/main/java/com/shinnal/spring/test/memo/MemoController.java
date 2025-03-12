package com.shinnal.spring.test.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class MemoController {

	@GetMapping("/login-view")
	public String inputLogin( ) {
		
		return "user/login";
	}
	
	// socket 통신 (login)
	
	
	
	@GetMapping("/join-view")
	public String inputJoin( ) {
		
		return "user/join";
	}
	
	
	
}
