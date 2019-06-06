/*
* File: MyRandomDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program generates numbers
* simulating Maryland's Mega-Millions Lottery
* Note: This allows reuse of picks so
* it does have some limitations.
*/

// Import statements
import java.util.Random;

public class MyRandomDemo {	
    public static void main(String[] args)  { 	

	// Display a Welcome note
       System.out.println("Welcome to the Mega-Millions Simulation");

	// Define a Constant
	final int MAXPICK = 75;
	final int MAXBONUS = 15;

	// Construct a Random class instance
        Random randomGen = new Random();

	// Variables to hold values
	int pickOne = 0;
	int pickTwo = 0;
	int pickThree = 0;
	int pickFour = 0;
	int pickFive = 0;
	int pickBonus = 0;
	
	// Generate a random Int 
	// but limit it between 1 and MAXPICK	
	pickOne = randomGen.nextInt(MAXPICK + 1) +1;	
	pickTwo = randomGen.nextInt(MAXPICK + 1 ) +1;	
	pickThree = randomGen.nextInt(MAXPICK + 1)+1;	
	pickFour = randomGen.nextInt(MAXPICK + 1)+1;
        pickFive = randomGen.nextInt(MAXPICK + 1)+1;
	pickBonus = randomGen.nextInt(MAXBONUS + 1)+1;

	// Display the results
        System.out.println("Your MegaMillion winners are: \n" + 
	"Pick 1: " + pickOne + "\n" +
	"Pick 2: " + pickTwo + "\n" +
	"Pick 3: " + pickThree + "\n" + 
	"Pick 4: " + pickFour + "\n" +
	"Pick 5: " + pickFive + "\n" + 
	"Bonus Pick: " + pickBonus + "\n");
       
    }
}