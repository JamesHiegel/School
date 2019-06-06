/*
* File: MathDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the use of static methods
* and fields of the Math class.
*/

// Import statements
import java.util.Scanner;

public class MathDemo {	
    public static void main(String[] args)  { 	

	// Display a Welcome note
       System.out.println("Welcome to the Math Class Demo");

	// Variables to hold values
	double angle = 0.0;
	int negativeInt = 0;
	
	// Use the Scanner class to input data
        Scanner scannerIn = new Scanner(System.in);

	System.out.println("Enter the angle in degrees (0.0-360.0):");
	// the nextInt() method scans the next int value
        angle = scannerIn.nextDouble();

	// Verify the angle was entered
	System.out.println("The following angle was entered " + angle);

	System.out.println("Enter a negative int of your choice :");
	// the nextInt() method scans the next int value
        negativeInt = scannerIn.nextInt();

	// Verify the int was entered
	System.out.println("The following negative Int was entered " + negativeInt);
	
	// Calculate the abs(), floor(), sqrt(), max() and round() of each entry
	System.out.println("abs() is " + Math.abs(angle) + "," + Math.abs(negativeInt));
	System.out.println("floor() is " + Math.floor(angle) + "," + Math.floor(negativeInt));
	System.out.println("sqrt() is " + Math.sqrt(angle) + "," + Math.sqrt(Math.abs(negativeInt)));
	System.out.println("max() is " + Math.max(angle,90.0) );
	System.out.println("round() is " + Math.round(angle) );

	// Convert the angel to radians
	angle = Math.toRadians(angle);
	System.out.println("Angle in radians is " + angle);

	// Calculate the sin, cos and tan values for the angle entered
	System.out.println("sin() is " + Math.sin(angle));
	System.out.println("cos() is " + Math.cos(angle));
	System.out.println("tan() is " + Math.tan(angle));

	// Generate some random numbers
	// A random int between 0 and 9
	int randInt = (int) (Math.random() * 10);
	System.out.println("(int) (Math.random() * 10) is " + randInt);
	// A random int between 100 and 999
	randInt = (int) (Math.random() * 900) +100 ;
	System.out.println("(int) (Math.random() * 900) +100 is " + randInt);
	// A random int between 100 and 999
	// Notice the pattern 
	//(int) (Math.random() * MAX) +OFFSET ;
	// Yields values between OFFSET and OFFSET + (MAX-1)
	randInt = (int) (Math.random() * 51) +50 ;	
	System.out.println("(int) (Math.random() * 51) +50 is " + randInt);
	//a Random int between 199 and 1000

	// Display the PI and E values
	System.out.println("PI is " + Math.PI);
	System.out.println("E is " + Math.E);	


    }
}