/*
* File: RandomDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the use of Java's 
* Random class
*/

// Import statements
import java.util.Random;

public class RandomDemo {	
    public static void main(String[] args)  { 	

	// Display a Welcome note
       System.out.println("Welcome to the Random Class Demo");

	// Variables to hold values
	int randInt = 0;
	boolean randBoolean = false;
	double randDouble = 0.0;

	// Construct a Random class instance
        Random randomGen = new Random();

	// Generate a random Int 
	// range will be from MIN to MAX Java int
	randInt = randomGen.nextInt();
	System.out.println("Random int: " + randInt);

	// Generate a random Int 
	// but limit it between 0 and 35	
	randInt = randomGen.nextInt(36);	
        System.out.println("Random int: " + randInt);

	// Generate a random boolean	
	randBoolean = randomGen.nextBoolean();	
        System.out.println("Random boolean: " + randBoolean);
	
	// Generate a random Double	
	randDouble = randomGen.nextDouble();	
        System.out.println("Random double: " + randDouble);
       
    }
}