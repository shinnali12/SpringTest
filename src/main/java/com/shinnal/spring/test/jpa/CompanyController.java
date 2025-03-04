package com.shinnal.spring.test.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnal.spring.test.jpa.domain.Company;
import com.shinnal.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@ResponseBody
	@GetMapping("/create")
	public Company createCompany() {

		// "넥손", "컨텐츠 게임", "대기업", 3585
		// "버블팡", "여신 금융업", "대기업", 6834
		
		Company company = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6834);
				
		return company;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany() {
		
		companyService.deleteCompany(8);
		
		return "삭제 성공";
		
	}
	
	
}
