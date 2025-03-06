package com.shinnal.spring.test.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnal.spring.test.jpa.domain.Recruit;
import com.shinnal.spring.test.jpa.repository.RecruitRepository;

@RequestMapping("/jpa/recruit/find")
@Controller
public class RecruitController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@ResponseBody
	@GetMapping("/1")
	public Recruit recruit1() {
		
		
		
//		recruitList = recruitRepository.findAllByOrderByIdDesc();
		
		// 1. id조회
		
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		
		Recruit recruit = optionalRecruit.orElse(null);
		
		return recruit;
		
	}	
		// 2. Request Parameter로 전달 받은 company id조회..??
		
		
	@ResponseBody
	@GetMapping("/2")
	public List<Recruit> recruit2(@RequestParam("companyId") int companyId) {
		
		List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);
		
		return recruitList;
		
	}
		


	
	@ResponseBody
	@GetMapping("/3")
	public List<Recruit> recruit3() {
		
		List<Recruit> recruitList = null;
		
		// 3. 웹 back-end 개발자 이고 정규직인 공고 조회
		
//		recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		
		// 4. 정규직이거나 연봉이 9000 이상인 공고 조회
		
//		recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		
	
		// 5. 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
		
//		recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		
		// 6. 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고 조회
		
		recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	
		
		// 7. 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순 조회
		
//		recruitList = recruitRepository.selectByNativeQuery("2026-04-10", 8100, "정규직");
		recruitList = recruitRepository.selectByNativeQuery(LocalDate.of(2026, 4, 10), 8100, "정규직");
		
		return recruitList;
		
	}
		

		

		

	
	

}
