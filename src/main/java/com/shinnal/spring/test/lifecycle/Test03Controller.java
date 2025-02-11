package com.shinnal.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {
	
	@RequestMapping("/lifecycle/test03/1")
	public String thymeleafResponse() {
		
		return "lifecycle/test03";
	}

}
