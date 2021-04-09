package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.Booking;

@Component
public class BookingExtractor implements ResultSetExtractor<Booking> {

	@Override
	public Booking extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		/*
		 * 	public int c_id;
	public String start_date ;
	public String end_date;
	public int room_number;
	public String room_type;
	public int balance;
	
		 */
		int cId = rs.getInt("c_id");
		
		String start_date = rs.getString("start_date");
		
		String end_date = rs.getString("end_date");
		
		int room_number = rs.getInt("room_number");
		
		String room_type = rs.getString("room_type");
		int balance = rs.getInt("balance");
		
		return new Booking(cId, start_date, end_date, room_number, room_type,balance);
	}

}
