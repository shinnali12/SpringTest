package com.shinnal.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.mvc.domain.Seller;
import com.shinnal.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public int addSeller(
			String nickname
			, double temperature
			, String porfileImage) {
		
		int count = sellerRepository.insertSeller(nickname, temperature, porfileImage);
		
		return count;
		
	}
	
	
	public Seller getLastSeller() {
		
		Seller seller = sellerRepository.selectLastSeller();
		
		return seller;
		
	}
	
}
