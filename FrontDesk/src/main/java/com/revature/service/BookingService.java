package com.revature.service;

import java.util.List;

import com.revature.pojo.Booking;

public interface BookingService {
	
	public List<Booking> retrieveAllBooking();
	
	public void removeBooking(int c_id, Booking booking);
	
	public Booking createBooking(Booking booking);
		
	public Booking getBookingById(int c_id);
	
	public void deleteBookingById(int c_id);
	
	public void updateBooking(Booking booking);


}
