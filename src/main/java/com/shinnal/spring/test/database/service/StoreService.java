package com.shinnal.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.database.domain.Store;
import com.shinnal.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	// 가게 정보 리스트 얻어오기
	public List<Store> getStoreList() {
		
		// store 테이블의 모든 행 조회하기 -> Repository 에서 정보 얻어오기		
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}

}
