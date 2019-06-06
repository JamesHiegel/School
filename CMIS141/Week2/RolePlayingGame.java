/*
* File: RolePlayingGame.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program provides output
* for a simple role playing game based on
* user input of N, E, S, and W.
*/

// Import statements
import java.util.Scanner;

public class RolePlayingGame {	
    public static void main(String[] args)  { 	

	// Display a Welcome note
       System.out.println("Stargate Role Playing Game");

	// Variables to hold values
	char direction = 'N';
		
	// Use the Scanner class to input data
        Scanner scannerIn = new Scanner(System.in);

	System.out.println("Enter the Direction (N,E,S,W):");
	// the next() method scans the next String value
	// the charAt(0) method takes the first character
        direction = scannerIn.next().charAt(0);

	// Verify the direction was entered
	System.out.println("The following char was entered " + direction);

	// Selection statement to determine Direction text-based results.
	switch (direction) {
	  case 'N': case 'n':
		// Print out North text
		System.out.println("The winds grow cold here");
		System.out.println("Are you sure you have made a good choice?");
		break;
	case 'E': case 'e': 
		// Print out East text
		System.out.println("East is quite nice this time of year");
		System.out.println("Be sure to bring your walking stick.");
		System.out.println("The mountains can be challenging.");
		break;
	case 'S': case 's':
		// Print out South text
		System.out.println("Ahhh... a Pioneer indeed.");
		System.out.println("Be sure to pack extra water.");
		break;		
	case 'W': case 'w':
		// Print out West text
		System.out.println("This in unknown territory");
		System.out.println("Be sure to bring your gold panning kit");
		break;	
	default:
		System.out.println("Please enter a valid entry (N,E,S,W)");
	}
		
	// Output the direction
	System.out.println("Thank you for entering the direction of " + direction);	


    }
}
