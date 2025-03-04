package com.shinnal.spring.test.ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinnal.spring.test.ajax.domain.Booking;
import com.shinnal.spring.test.ajax.service.BookingService;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingService.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/PensionBookinginfo";
	}
	
	@GetMapping("/input")
	public String bookingInput() {
		return "ajax/PensionBookinginput";		
	}
	
	@GetMapping("/main")
	public String bookingMain() {
		return "ajax/PensionHome";		
	}
	
	
	@ResponseBody
	@GetMapping("/create")
	public Map<String, String> createdBooking(
			@RequestParam("name") String name
			, @DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
		
		// 성공 {"result":"success"} 
		// 실패 {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		
		return resultMap;
		
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteBooking(@RequestParam("id") int id){
		
		int count = bookingService.deleteBooking(id);
		
		// 성공 {"result":"success"} 
		// 실패 {"result":"fail"}
				
		Map<String, String> resultMap = new HashMap<>();
			
		if(count == 1) {
		resultMap.put("result", "success");
		} else {
		resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	@ResponseBody
	@GetMapping("/info")
	public Map<String, Object> bookingInfo(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingService.getBooking(name, phoneNumber);
		
		// 조회 성공 {"result":"success", "data":{"name":"장나라", "day":3, ......}} 
		// 조회 실패 {"result":"fail"}
		
		Map<String, Object> resultMap = new HashMap<>();
		
		if(booking != null) {
			// 성공
			resultMap.put("result", "success");
			resultMap.put("data", booking);
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
}
