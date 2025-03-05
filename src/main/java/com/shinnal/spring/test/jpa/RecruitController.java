package com.shinnal.spring.test.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnal.spring.test.jpa.domain.Recruit;
import com.shinnal.spring.test.jpa.repository.RecruitRepository;

@Controller
public class RecruitController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@ResponseBody
	@GetMapping("/jpa/recruit/find")
	public List<Recruit> findRecruit() {
		
		List<Recruit> recruitList = null;
		
//		recruitList = recruitRepository.findAllByOrderByIdDesc();
		
		// 1. id조회
		
//		recruitList = recruitRepository.findById(8);
		
		// 2. Request Parameter로 전달 받은 company id조회..??
		
//		recruitList = recruitRepository.findByCompanyId(1);
		
		// 3. 웹 back-end 개발자 이고 정규직인 공고 조회
//		recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		// 4. 정규직이거나 연봉이 9000 이상인 공고 조회 
		
//		recruitList = recruitRepository.findByTypeOrSalaryGreaterThan("정규직", 9000);
		
		// 5. 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
		
//		recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		// 6. 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고 조회
		
//		recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		// 7. 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순 조회
		
		recruitList = recruitRepository.selectByDeadlineAndSalaryAndType(null, null, null);
		
		return recruitList;
	}
	
	

}
