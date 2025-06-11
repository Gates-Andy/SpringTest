package com.andy.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andy.test.ajax.domain.Booking;
import com.andy.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax")
public class BookingController {
	@Autowired
	private BookingService BookingService;

	@GetMapping("/list")
	public String bookingList(Model model) {

		List<Booking> bookingStatus = BookingService.getBooking();

		model.addAttribute("bookingStatus", bookingStatus);

		return "ajax/list2";

	}

	@PostMapping("/input")
	public String addbooking(Model model) {

		return "ajax/input2";

	}
}
