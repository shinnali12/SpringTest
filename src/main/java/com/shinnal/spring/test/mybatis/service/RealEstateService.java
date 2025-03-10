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
		
		// 테이블에서 전달 받은 면적 보다 넓고, 가격보다 납은 매매 매물 행 조회
		List<RealEstate> realEstate = realEstateRepository.selectRealEstateAreaPrice(area, price);
		
		return realEstate;
	}
	
	
// insert 쿼리 1
	
	public int addRealEstateCreate(RealEstate realEstate) {
		
		int count = realEstateRepository.insertRealEstateCreate(realEstate);
		
		
		return count;
	}
	
	
// insert 쿼리 2
	

	public int addRealEstateObject(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {

		int count = realEstateRepository.insertRealEstateObject(realtorId, address, area, type, price, rentPrice);
				
		return count;
		
	}
	
	
	
	
//	update 쿼리
	public int upDateRealEstate(RealEstate realEstate) {
		

		
		int count = realEstateRepository.upDateRealEstate(realEstate);
		
		return count;
		
	}

	
//	update 쿼리 풀이	
//	전달받은 id와 일치하는 매물정보의 type과 가격을 전달 받은 값으로 수정
//	
//	public int updateRealEstate(int id, String type, int price) {
//		
//		int count = realEstateRepository.updateRealEstate(id, type, price);
//		
//		return count;
//		
//	}
	
	
	
	
//	delete 쿼리
	public int deleteRealEstate(int id) {
		
		int count = realEstateRepository.deleteRealEstate(id);
		
		return count;
		
	}

}

