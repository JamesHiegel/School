/*
* File: SelectionIfDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the use of if/else selection
* statements.
*/

// Import statements
import java.util.Scanner;

public class SelectionIfDemo {	
    public static void main(String[] args)  { 	

	// Display a Welcome note
       System.out.println("Welcome to the if/else Demo");

	// Variables to hold values
	int month = 0;
	int numDays = 0;
	
	// Use the Scanner class to input data
        Scanner scannerIn = new Scanner(System.in);

	System.out.println("Enter the Month (1-12):");
	// the nextInt() method scans the next int value
        month = scannerIn.nextInt();

	// Verify the month  was entered
	System.out.println("The following month was entered " + month);

	// Selection statement to determine number 
	// of days in month
	if ((month == 1)  ||
            (month == 3)  ||
            (month == 5)  ||
            (month == 7)  ||
            (month == 8)  ||
            (month == 10) ||
            (month == 12) ) {
		numDays = 31;
	}
	else if (month == 2) {
		numDays = 28;
	}
	else if ((month == 4) ||
                 (month == 6) ||
                 (month == 9) ||
                 (month == 11) ) {
		numDays = 30;
	}
	else {
		System.out.println("Month is not a value between 1 and 12");
		// Exit the application for invalid Months
		System.exit(0);
	}		

	// Output the number of days in the selected month
	System.out.println("Number of Days in month " + month +
            " is " + numDays);	


    }
}
