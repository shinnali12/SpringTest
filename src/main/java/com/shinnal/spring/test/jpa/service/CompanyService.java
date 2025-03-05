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
		
		if(optionalCompany.isPresent()) {// null의 값을 보여줌
			Company company = optionalCompany.get();
			
			// Company company = optionalCompany.orElse(null); // null 처리
			
			company = company.toBuilder().scale(scale).headcount(headcount).build(); // 정보 수정
			
			Company result = companyRepository.save(company); // 수정된 정보 적용
			
			return result;
		}
		
		return null;
		
	}
	
	public void deleteCompany(int id) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id); // id조회

		//Company company = optionalCompany.orElse(null); // null 처리
		
//		if(optionalCompany.isPresent()) {
//			Company company = optionalCompany.get();
//			companyRepository.delete(company); // 삭제
//		}
		
		// 람다식 표현 - 자바의 메소드를 간결한 함수식으로 표현 일급객체인 함수를 변수처럼 사용가능, 매개 변수로 전달이 가능
		optionalCompany.ifPresent(company -> companyRepository.delete(company));
		
		
		
	}
	
	
}
