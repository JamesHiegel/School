/*
* File: MyStringDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the use of Java's 
* String and wrapper classes for number conversions
*/

// Import statements
import java.util.Scanner;

public class MyStringDemo {	
    public static void main(String[] args)  { 	

	// Variables to hold values
	String message1;
	String message2;	
	int age = 0;
	int birthday = 0;

	// Construct a Scanner class
        Scanner scannerIn = new Scanner(System.in);

	// Prompt user for welcome messages
	System.out.println("Enter a message");
	// Scan the string
	message1 = scannerIn.next();
	System.out.println("Enter another message");
	// Scan the string
	message2 = scannerIn.next();

	// Concatenate and print values
	String messageCombo = message1.concat(" ").concat(message2);
	String messageCombo2 = message1 + " " + message2;
	System.out.println("Strings are: \n" +
		message1 + "," + message1.length() + "\n" +
		message2 + "," + message2.length() + "\n" +
		messageCombo + "," + messageCombo.length() );
	System.out.println("+ Strings are: \n" +
		message1 + "," + message1.length() + "\n" +
		message2 + "," + message2.length() + "\n" +
		messageCombo2 + "," + messageCombo2.length() );

	// Prompt user for age
	System.out.println("Enter your age (e.g. 23)");
	// Scan the string and parse
	age = Integer.parseInt(scannerIn.next());

	// Prompt user for birthday
	System.out.println("Enter your birthday (e.g. 19)");
	// Scan the string and parse
	birthday = Integer.parseInt(scannerIn.next());

	// Convert to Strings
	String stringAge = Integer.toString(age);
	String stringDay = Integer.toString(birthday);
	String stringCombo = stringAge.concat(stringDay);
	System.out.println("Converted Strings are: \n" +
		stringAge + "," + stringAge.length() + "\n" +
		stringDay + "," + stringDay.length() + "\n" +
		stringCombo + "," + stringCombo.length() );
		       
    }
}