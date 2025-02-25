package com.shinnal.spring.test.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
