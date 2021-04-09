package com.revature.dao;

import java.util.List;

import com.revature.pojo.Booking;

public interface BookingDao {
	
	public Booking addBooking(Booking booking); 
	public void removeBooking(Booking booking); 
	public Booking updateBooking(Booking booking); 
	public List<Booking> getAllBooking(); 
}
