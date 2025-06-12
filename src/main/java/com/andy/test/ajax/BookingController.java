package com.andy.test.ajax;

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

import com.andy.test.ajax.domain.Booking;
import com.andy.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {
	@Autowired
	private BookingService BookingService;

	@GetMapping("/main")
	public String bookingMain() {

		return "ajax/booking/main";

	}

	@GetMapping("/list")
	public String bookingList(Model model) {

		List<Booking> bookingList = BookingService.getBooking();

		model.addAttribute("bookingList", bookingList);

		return "ajax/booking/list";

	}

	@GetMapping("/input")
	public String addbooking(Model model) {

		return "ajax/booking/input";

	}

	@ResponseBody
	@GetMapping("/create")
	public Map<String, String> createBooking(@RequestParam("name") String name,
			@DateTimeFormat(pattern = "yyyy년 M월 d일") @RequestParam("date") LocalDate date, @RequestParam("day") int day,
			@RequestParam("headcount") int headcount, @RequestParam("phoneNumber") String phoneNumber) {

		Map<String, String> resultMap = new HashMap<>();

		int count = BookingService.addBooking(name, date, day, headcount, phoneNumber);

		if (count == 1) {

			resultMap.put("result", "success");

		} else {

			resultMap.put("result", "fail");
		}

		return resultMap;

	}

	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {

		int count = BookingService.deleteBookingById(id);

		Map<String, String> resultMap = new HashMap<>();

		if (count == 1) {

			resultMap.put("result", "success");

		} else {

			resultMap.put("result", "fail");

		}

		return resultMap;

	}

}
