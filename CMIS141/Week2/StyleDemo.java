/*
* File: StyleDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the use of Standard I/O
* classes including the BufferedReader and Scanner classes.
*/

// Import each required Java class
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * StyleDemo
 */
public class StyleDemo {	
    public static void main(String[] args) throws IOException { 
	// Variables to hold values
	int favInt = 0;
	double favDouble = 0.0;
	int secondFavInt = 0;
	double secondFavDouble = 0.0;
	boolean favBoolean = false;
	short favShort = 0;
        byte favByte = 0;
        final double PI = 3.1416;
	
        // Define a InputStreamReader based on Standard Input (System.in)
        InputStreamReader isReader = new InputStreamReader(System.in);
	// Send the InputStreamReader to a BufferedReader
        BufferedReader stdin = new BufferedReader(isReader);
	
	// Prompt the user to enter an int
	System.out.println("Enter your favorite integer:");
	// The readLine() method reads everything entered
	// However the Integer.parseInt() method converts 
	// the value to an int
        favInt = Integer.parseInt(stdin.readLine());

	// Prompt the user to enter an double
	System.out.println("Enter your favorite double number:");
	// Read the line and convert to a double
        favDouble = Double.parseDouble(stdin.readLine());
 
	// Print the results to verify your data
        System.out.println("Your favorite int is: " + favInt);
	System.out.println("Your favorite double is: " + favDouble);

	// Use the Scanner class to perform the same functionality
        Scanner scannerIn = new Scanner(System.in);

	// Prompt the user to enter another int
	System.out.println("Enter your second favorite integer:");
	// the nextInt() method scans the next int value
        secondFavInt = scannerIn.nextInt();

	// Prompt the user to enter another double
	System.out.println("Enter your second favorite double number:");
	// the nextDouble() method scans the next double value
        secondFavDouble = scannerIn.nextDouble();

	// Prompt the user to enter a boolean
	System.out.println("Enter your favorite boolean value:");
	// the nextBoolean() method scans the next boolean value
        favBoolean = scannerIn.nextBoolean();

	// Prompt the user to enter a short
	System.out.println("Enter your favorite short value:");
	// the nextShort() method scans the next short value
        favShort = scannerIn.nextShort();

	// Print the results to verify your data
        System.out.println("Your second favorite int is: " + secondFavInt);
 	System.out.println("Your second favorite double is: " + secondFavDouble);
	System.out.println("Your favorite boolean is: " + favBoolean);
	System.out.println("Your favorite short is: " + favShort);	

	// Prompt the user to enter a byte
	System.out.println("Enter your favorite byte value:");
	// the nextByte() method scans the next byte value
        favByte = scannerIn.nextByte();
        System.out.println("Your favorite byte is: " + favByte);
    }
}
