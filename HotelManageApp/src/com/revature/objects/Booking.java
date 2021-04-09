package com.revature.objects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import com.revature.AccountPostgres;
import com.revature.User;

import java.util.Random;
public class Booking {
	
	public static void startStay(AccountPostgres acc, String userName) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int roomNumber = random.nextInt(200); 
		System.out.println("You started booking your room.");
		System.out.println("What day would you like to start your stay with us?");
		//System.out.println("Please enter in yyyy-MM-dd HH:mm:ss format");
		System.out.println("Please enter the Month.");
		int month = scanner.nextInt();
		System.out.println("Please enter the Day.");
		int day = scanner.nextInt();
		System.out.println("Please enter the hour (out of 24). HH format");
		int hour = scanner.nextInt();
		
		/*
		LocalDate myObj = LocalDate.now(); // Create a date object
	    System.out.println("Today is "+myObj);
	    
	    //DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
	    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy MM dd");

	    LocalTime lt = LocalTime.parse("1994-08-01");
	    //System.out.println(df.format(lt.plusMinutes(10)));
	    */
		String monthString = Integer.toString(month);
		String dayString = Integer.toString(day);
		String hourString = Integer.toString(hour);
	    if (month<10) {
	    	monthString="0"+month;
	    	
	    }
	    if (day<10) {
	    	dayString="0"+day;
	    	
	    }
	    if (hour<10) {
	    	hourString="0"+hour;
	    	
	    }
		String startDate = 2021+"-"+monthString+"-"+dayString+" "+hourString+":00";
	    
	    //String input = "1994-08-01 14:37";
	    //String input = "1994-08-01";
	    //LocalDateTime ldt = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	    LocalDateTime ldt = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	    //LocalDateTime ldt = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    String formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
	    System.out.println(formatted);
	    
	    acc.setStartDateByUsername(formatted, userName);
	    acc.setRoomNumberByUsername(roomNumber, userName);

	}
	
	public static void endStay(AccountPostgres acc, String userName) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What day would you like to end your stay with us?");
		//System.out.println("Please enter in yyyy-MM-dd HH:mm:ss format");
		System.out.println("Please enter the Month. MM format");
		int month = scanner.nextInt();
		System.out.println("Please enter the Day. dd format ");
		int day = scanner.nextInt();
		System.out.println("Please enter the hour (out of 24). HH format");
		int hour = scanner.nextInt();
		
		/*
		LocalDate myObj = LocalDate.now(); // Create a date object
	    System.out.println("Today is "+myObj);
	    
	    //DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
	    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy MM dd");

	    LocalTime lt = LocalTime.parse("1994-08-01");
	    //System.out.println(df.format(lt.plusMinutes(10)));
	    */
		String monthString = Integer.toString(month);
		String dayString = Integer.toString(day);
		String hourString = Integer.toString(hour);
	    if (month<10) {
	    	monthString="0"+month;
	    	
	    }
	    if (day<10) {
	    	dayString="0"+day;
	    	
	    }
	    if (hour<10) {
	    	hourString="0"+hour;
	    	
	    }
		String startDate = 2021+"-"+monthString+"-"+dayString+" "+hourString+":00";
	    
	    //String input = "1994-08-01 14:37";
	    //String input = "1994-08-01";
	    //LocalDateTime ldt = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	    LocalDateTime ldt = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	    //LocalDateTime ldt = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    String formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
	    System.out.println(formatted);
	    
	    acc.setEndDateByUsername(formatted, userName);

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
