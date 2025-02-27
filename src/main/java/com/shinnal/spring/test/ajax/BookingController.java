package com.shinnal.spring.test.ajax;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinnal.spring.test.ajax.domain.Booking;
import com.shinnal.spring.test.ajax.service.BookingService;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
//	@ResponseBody
//	@PostMapping("/create")
//	public String bookingCreate(
//			@RequestParam("name") String name
//			, @DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date
//			, @RequestParam("day") int day
//			, @RequestParam("headcount") int headcount
//			, @RequestParam("phoneNumber") String phoneNumber) {
//		
//		
//		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
//		
//		model.addAttribute("booking", booking);
//		
//		return "결과" + count;
//		
//	}
	
	
	@GetMapping("/listInfo")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingService.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/PensionBookinginfo";
	}
	
//	@ResponseBody
//	@PostMapping("/input")
//	public String bookingInput() {
//		
//		return ;
//	}
	
	
	
}
