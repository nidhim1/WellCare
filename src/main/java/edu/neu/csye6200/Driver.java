package edu.neu.csye6200;

import edu.neu.csye6200.Controller.Routes;

/**
 * 
 * @author Rohan
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");

         //Add your code in between these two print statements
		Routes routes = new Routes();
		routes.navigateTo("login");

		System.out.println("\n\n============Main Execution End===================");
	}

}
