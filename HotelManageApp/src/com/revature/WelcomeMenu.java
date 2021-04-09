package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;



public class WelcomeMenu {
	Logger logger = Logger.getRootLogger();
	
	public void welcome(Scanner scanner) {
		System.out.println("Welcome to Casa Bonita Hotel");
		//System.out.println("Are you an employee or customer?");
		System.out.println("Have you stayed with us before? Y or N");
		String welcome = scanner.nextLine();
		welcome = welcome.toUpperCase();
		LoginMenuPostgres log = new LoginMenuPostgres();
		RegisterMenuPostgres reg = new RegisterMenuPostgres();
		reg.setLog(logger);
		log.setLog(logger);
		if (welcome.equals("Y")) {
			log.login(scanner);			
		} else if (welcome.equals("N")) {
			reg.setLog(logger);
			reg.register(scanner);			
		} else {
			System.out.println("We didn't quite get that please try again.");
			WelcomeMenu wel = new WelcomeMenu();
			wel.welcome(scanner);
		}			
	}
}
