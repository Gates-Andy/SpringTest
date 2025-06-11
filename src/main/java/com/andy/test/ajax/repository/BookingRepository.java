package com.andy.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.andy.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {

	public List<Booking> selectBooking();
}
