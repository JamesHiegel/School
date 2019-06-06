/*
* File: StringDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the use of Java's 
* String and wrapper classes for number conversions
*/

// Import statements
import java.util.Scanner;

public class StringDemo {	
    public static void main(String[] args)  { 	


	// Construct strings using literal assignment
	String welcome = "Welcome to the String Demo";

	// Display the Welcome note
        System.out.println(welcome);

	// Use the typical method to construct a class:
	String welcome2 = new String("Welcome again!");

	// Display the second Welcome note
        System.out.println(welcome2);

	// Use the concatenation method 
	String concatWelcome = welcome.concat(welcome2);
	// Achieve the same results with the + concatenation
	String concatWelcome2 = welcome + welcome2;

	// Display Concatenated Strings.
	System.out.println("concatWelcome: " + concatWelcome);
	System.out.println("concatWelcome2: " + concatWelcome2);
	
	// Display the length of each of the Strings
	String lengthString = "String lengths are:\n" +
		      "welcome: "+ welcome.length() +
		      "\nwelcome2: "+ welcome2.length() +
	              "\nconcatWelcome: "+ concatWelcome.length() +
	              "\nconcatWelcome2: "+ concatWelcome2.length();
	System.out.println(lengthString);

	// To add a space between the messages
	concatWelcome = welcome.concat(" ").concat(welcome2);
	// Achieve the same results with the + concatenation
	concatWelcome2 = welcome + " " + welcome2;

	// Redisplay Concatenated Strings.
	System.out.println("concatWelcome with space: " + concatWelcome);
	System.out.println("concatWelcome2 with space: " + concatWelcome2);

	// ReDisplay the length of each of the Strings
	// One additional character is added for the space
	lengthString = "String lengths are:\n" +
		      "welcome: "+ welcome.length() +
		      "\nwelcome2: "+ welcome2.length() +
	              "\nconcatWelcome: "+ concatWelcome.length() +
	              "\nconcatWelcome2: "+ concatWelcome2.length();
	System.out.println(lengthString);
	
	// Variables to hold values
	int age = 0;	
	double avgScore = 0.0;

	// Construct a Scanner class
        Scanner scannerIn = new Scanner(System.in);

	// Prompt user for age and avgScore
	System.out.println("Enter your age (e.g. 43)");
	// Scan the next String and parse the Integer value
	age = Integer.parseInt(scannerIn.next());

	System.out.println("Enter your average score(e.g. 83.3)");
	// Scan the next String and parse the Integer value
	avgScore = Double.parseDouble(scannerIn.next());

	// Display the results of the scans and parsing
	System.out.println("Age and average score are: " + 
        age + "," + avgScore);

	// We can also convert numbers to Strings
	String stringAge = Integer.toString(age);
	String stringScore = Double.toString(avgScore);
	// DiIsplay results
	System.out.println("String age and score are: " + 
          stringAge + "," + stringScore);
	
       
    }
}