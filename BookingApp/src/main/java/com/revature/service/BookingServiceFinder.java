package com.revature.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.pojo.Booking;

@Service
public class BookingServiceFinder implements BookingService {
	
	private static final String url = "http://localhost:8080/FrontDesk/booking";
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Booking> retrieveAllBooking() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Booking>> bookingList = bookingList = restTemplate.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference <List<Booking>> () {});
 		return bookingList.getBody();
	}

}
