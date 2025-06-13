package com.andy.test.ajax.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.andy.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {

	public List<Booking> selectBooking();

	public int insertBooking(@Param("name") String name, @Param("date") LocalDate date, @Param("day") int day,
			@Param("headcount") int headcount, @Param("phoneNumber") String phoneNumber);

	public int deleteBookingById(@Param("id") int id);

	public List<Booking> selectBookingByNameAndPhone(@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);

}
