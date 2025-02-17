package com.shinnal.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shinnal.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
//	1
	public RealEstate selectRealEstate(@Param("id") int id);
	
//	2
	public List<RealEstate> selectRealEstateRentPrice(@Param("rentPrice") int rentPrice);
	
//	3
	public List<RealEstate> selectRealEstateAreaPrice(@Param("area") int area, @Param("price") int price);
	
// insert 쿼리 1	
	
	public int insertRealEstateCreate(RealEstate realEstate);
	
	
// insert 쿼리 2
	public int insertRealEstateObject(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	
//	update 쿼리	
	public int upDateRealEstate(RealEstate realEstate);
	
//	update 쿼리 풀이
//	전달받은 id와 일치하는 매물정보의 type과 가격을 전달 받은 값으로 수정	
//	public int updateRealEstate(
//			@Param("id") int id
//			, @Param("type") String type
//			, @Param("price") int price);	
	
	
//	delete 쿼리
	public int deleteRealEstate(@Param("id") int id);
	
	
}

