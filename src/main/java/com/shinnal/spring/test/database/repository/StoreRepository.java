package com.shinnal.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shinnal.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	
	// store 테이블의 모든 행 조회
	public List<Store> selectStoreList();
	
	// selectStoreList();가 수행되기 위한 쿼리를 xml로 구현한다!!!

}
