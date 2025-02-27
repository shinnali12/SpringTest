package com.shinnal.spring.test.ajax.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shinnal.spring.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {
	
	public int insertBooking(@Param("name") String name
			, @Param("date") LocalDate date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber") String phoneNumber);
	
	public List<Booking> selectBooking();
	
}
