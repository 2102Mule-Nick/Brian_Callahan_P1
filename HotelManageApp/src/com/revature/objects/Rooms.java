package com.revature.objects;

import java.util.Scanner;

import com.revature.AccountPostgres;

public class Rooms {
	public void availableRooms(AccountPostgres acc, String userName) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Here are the room types available");
		System.out.println("-Room Types-");
		System.out.println("a. Single Bed, $100");
		System.out.println("b. Double Bed, $200");
		System.out.println("c. Triple Bed, $300");

		System.out.println("Please enter a choice.");	
		
		String option = scanner.next();
		
		if (option.equals("a")) {
			System.out.println("a was chosen");
			
			acc.updateBalance(100, userName);
		}
		if (option.equals("b")) {
			System.out.println("a was chosen");
			acc.updateBalance(200, userName);
		}
		if (option.equals("c")) {
			System.out.println("a was chosen");
			acc.updateBalance(300, userName);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
