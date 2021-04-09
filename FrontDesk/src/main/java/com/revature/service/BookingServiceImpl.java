package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BookingDao;
import com.revature.pojo.Booking;

@Service
public class BookingServiceImpl implements BookingService {
	
	private BookingDao bookingDao;

	@Autowired
	public void setBookingDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}

	@Override
	public List<Booking> retrieveAllBooking() {
		// TODO Auto-generated method stub
		return bookingDao.getAllBooking();
	}

	@Override
	public void removeBooking(int c_id, Booking booking) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking getBookingById(int c_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookingById(int c_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}

}
