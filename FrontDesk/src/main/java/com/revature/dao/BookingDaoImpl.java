package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.BookingRowMapper;
import com.revature.pojo.Booking;

@Repository
public class BookingDaoImpl implements BookingDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private BookingRowMapper bookingRowMapper;
	
	@Autowired
	public void setBookingRowMapper(BookingRowMapper bookingRowMapper) {
		this.bookingRowMapper = bookingRowMapper;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBooking(Booking booking) {
		// TODO Auto-generated method stub

	}

	@Override
	public Booking updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		String sql = "select c_id, start_date, end_date,room_number,room_type,balance from c_data;";
		List<Booking> bookingList = jdbcTemplate.query(sql, bookingRowMapper);
		return bookingList;
	}
}
