package com.shinnal.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public int addSeller(
			int id
			, String nickname
			, double temperature
			, String porfileImage) {
		
		
	}
	
}
