/*
* File: MySelectionIfDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program calculates and prints the 
* income tax based on input received from a user.
*/

// Import statements
import java.util.Scanner;

public class MySelectionIfDemo {	
    public static void main(String[] args)  { 	

	// Display a Welcome note
       System.out.println("Welcome to the Income Tax Demo");

	// Variables to hold values
	int income = 0;
	double tax = 0.0;
	
	// Use the Scanner class to input data
        Scanner scannerIn = new Scanner(System.in);

	System.out.println("Enter your annual income (>0):");
	// the nextInt() method scans the next int value
        income = scannerIn.nextInt();

	// Verify the income was entered
	System.out.println("The following income was entered " + income);

	// Selection statement to determine number 
	// of days in month
	if (income < 0) {
		System.out.println("Income must be great than 0");
		// Exit the application 
		System.exit(0);
	}
	else if (income < 20000 ) {
		tax=income*0.11;
	}
	else if (income < 40000) {
		tax=income*0.12;
	}
	else if (income < 60000) {
		tax=income*0.14;
	}
	else if (income >= 60000) {
		tax=income*0.15;	
	}
	

	// Output the number of tax for the income
	System.out.println("For your income of " + income +
            " the tax is " + tax);	


    }
}
