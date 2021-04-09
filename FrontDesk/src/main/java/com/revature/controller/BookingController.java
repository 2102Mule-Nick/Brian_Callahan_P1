package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.Booking;
import com.revature.service.BookingService;

@RestController
public class BookingController {
	BookingService bookingService;
	
	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@GetMapping("/booking")
	public List<Booking> getBooking(){
		return bookingService.retrieveAllBooking();
	}
	

}
