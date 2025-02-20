package com.shinnal.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.shinnal.spring.test.mvc.domain.Realtor;

@Mapper
public interface RealtorRepository {
	

	public int insertRealtor(Realtor realtor); 

}
