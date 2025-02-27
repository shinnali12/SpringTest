package com.shinnal.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.ajax.domain.Favorite;
import com.shinnal.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public int addFavorite(String name
			, String url) {
		
		int count = favoriteRepository.insertFavorite(name, url);
				
		return count;
		
	}
	
	public List<Favorite> getFavorite() {
		
			List<Favorite> favorite = favoriteRepository.selectFavorite();
			
		return favorite;
	}
	
	// 중복 체크
	
	public boolean isDuplicateUrl(String url) {
		
		int count = favoriteRepository.selectCountUrl(url);
		
		return count != 0; // count 값이 0이 아니면 true이므로 리턴하여 true/false 값을 전달한다. 
		
		
		
//		if(count == 0) {
//			return false; // 중복된게 없음
//		} else {
//			return true; // 중복된게 1개이상 있음
//		}
		
	}
	
		
	// 테이블내용 삭제
	
	public int deleteFavorite(int id) {
		
		int count = favoriteRepository.deleteFavorite(id);
		
		return count;
		
	}
	
	
}
