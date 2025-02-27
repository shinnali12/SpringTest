package com.shinnal.spring.test.ajax.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinnal.spring.test.ajax.domain.Booking;
import com.shinnal.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
//	public int addBooking(String name
//			, LocalDate date
//			, int day
//			, int headcount
//			, String phoneNumber) {
//		
//		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber);
//		
//		return count;
//		
//	}
	
	public List<Booking> getBookingList() {
		
		List<Booking> bookingList = bookingRepository.selectBooking();
		
		return bookingList;
		
	}
	
	
}
