package com.shinnal.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shinnal.spring.test.mvc.domain.Realtor;
import com.shinnal.spring.test.mvc.service.RealtorService;

@RequestMapping("/mvc/realtor")
@Controller
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
//	@ResponseBody
	@GetMapping("/create")
	public String createRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade
			, Model model) {
			
		
		
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.addRealtor(realtor);
		
		
		model.addAttribute("realtor", realtor);
		
		return "mvc/RealtorInfo";
		
	}
	
	@GetMapping("/input")
	public String realtorInput() {
		
		return "mvc/RealtorInput";
	}
	
//	@GetMapping("/info")
//	public String realtorInfo() {
//		
//		return "mvc/RealtorInfo";
//	}
	
}
