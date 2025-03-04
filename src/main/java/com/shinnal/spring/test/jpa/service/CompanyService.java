package com.shinnal.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.jpa.domain.Company;
import com.shinnal.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(
			String name
			, String business
			, String scale
			, int headcount) {
		
		Company company = Company.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		Company result = companyRepository.save(company);
		
		return result;
		
	}
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id); // id조회
		
		Company company = optionalCompany.orElse(null); // null 처리
		
		company = company.toBuilder().scale(scale).headcount(headcount).build(); // 정보 수정
		
		Company result = companyRepository.save(company); // 수정된 정보 적용
		
		return result;
		
	}
	
	public void deleteCompany(int id) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id); // id조회

		Company company = optionalCompany.orElse(null); // null 처리
		
		companyRepository.delete(company); // 삭제
		
	}
	
	
}
