package com.shinnal.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepository {
	
	public int insertSeller(
			@Param("id") int id
			, @Param("nickname") String nickname
			, @Param("temperature") double temperature
			, @Param("profileImage") String profileImage);
	

}
