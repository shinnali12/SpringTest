package com.shinnal.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.mybatis.domain.RealEstate;
import com.shinnal.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
		
	public RealEstate getRealEstate(int id) {
	
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
				
		return realEstate;
		
	}
	
//	2.
	public List<RealEstate> getRealEstateRentPrice(int rentPrice) {
		
		List<RealEstate> realEstate = realEstateRepository.selectRealEstateRentPrice(rentPrice);
		
		return realEstate;
		
	}
	

//	3. 
	public List<RealEstate> getRealEstateAreaPrice(int area, int price) {
		
		List<RealEstate> realEstate = realEstateRepository.selectRealEstateAreaPrice(area, price);
		
		return realEstate;
	}

}

