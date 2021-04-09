package com.revature;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class Driver {
	/*
	 *   Documentation (all methods have basic documentation)
		 Unit testing (100% coverage)
		 Logging
		 1 Java application that will handle a publicly facing REST API
		 3 additional Java applications that will handle parts of the logic
		 at least 2 of the applications communicate to one another using REST
		 at least 2 of the applications communicate to one another using SOAP
		 at least 1 JMS Topic for applications to communicate
		 at least 1 JMS Queue for applications to communicate
	 */
	
	public static void main(String[] args) {	
		//System.out.println("hello welcome");
		Scanner scanner = new Scanner(System.in);
		WelcomeMenu welcome = new WelcomeMenu();
		welcome.welcome(scanner);
	}
}

