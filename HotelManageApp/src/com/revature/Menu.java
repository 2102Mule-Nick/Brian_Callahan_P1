package com.revature;

import java.util.Scanner;

import com.revature.objects.Booking;
//import com.revature.objects.Payments;
import com.revature.objects.Records;
import com.revature.objects.RoomService;
import com.revature.objects.Rooms;


public class Menu {
	
public void menu(User user, Scanner scanner) throws UserNotFound {
		String choice ="";
		AccountPostgres acc = new AccountPostgres(user);
		System.out.println();
		System.out.println("Welcome "+user.getUsername());
		System.out.println("Select an option");
		System.out.println("1: Booking");
		System.out.println("2: Rooms Available");
		System.out.println("3: Room Service");
		System.out.println("4: Records(Past Stays)");
		System.out.println("5: Exit");		

		do {
		choice = scanner.next();
		choice=choice.toUpperCase();
		
		switch (choice) {
		case "1": //booking
			Booking book = new Booking();
			book.startStay(acc,user.getUsername());
			book.endStay(acc,user.getUsername());			
			break;
		case "2": //rooms available
			Rooms room = new Rooms();
			room.availableRooms(acc,user.getUsername());
			break;
		case "3": //room service
			RoomService food = new RoomService();
			food.menu();
			break;
		case "4": //records
			Records record = new Records();
			record.record(acc,user.getUsername());
			//System.out.println("Here are your records");			
			break;
		case "5": //exit
			System.out.println("Exiting");
			break;	
		default:
			System.out.println("Please type a valid input");					
		}	
		}while (!choice.equalsIgnoreCase("E"));		
	}
}
