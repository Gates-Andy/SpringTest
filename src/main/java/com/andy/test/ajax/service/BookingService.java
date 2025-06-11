package com.andy.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andy.test.ajax.domain.Booking;
import com.andy.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository BookingRepository;

	public List<Booking> getBooking() {
		
		List<Booking> Booking = BookingRepository.selectBooking();
		
		return Booking;
		
	}
	
}
