/*
* File: CompoundInterest.java
* Author: James Hiegel
* Date: Novemeber 8, 2015
* Purpose: This program will calculate the compount interest of an account based upon
* an inputted present value, interest rate and timeframe.
*/

// Import statements
import java.util.Scanner;

public class CompoundInterest {	
    public static void main(String[] args)  { 	
		
	System.out.println("Welcome to the Compount Interest Calculator");
	System.out.println("This program will calculate the compount interest of an account based upon " +
 	"an inputted present value, interest rate and timeframe.");
	
	// Declare and initialize variables
	double futureValue = 0.0;
	double presentValue = 0.0;
	double nomIntRate = 0.0;
	int compFreq = 12; // assume interest is compounded monthly
	int timeInYears = 0;
	char calcAgain = 'y';
	
	// Scanner class
	Scanner scannerIn = new Scanner(System.in);

	do {
		// Request present value
		System.out.println("Enter the starting account balance:");
		presentValue = scannerIn.nextDouble();

		// Request interest rate
		System.out.println("Enter the interest rate:");
		nomIntRate = scannerIn.nextDouble() / 100;

		// Request time in years
		System.out.println("Enter how many years to calculate for:");
		timeInYears = scannerIn.nextInt();
		
		// Calculate compound interest F=P(1+i/n)^(n*t)
		futureValue = presentValue * Math.pow((1 + (nomIntRate / compFreq)), (compFreq * timeInYears));
		
		// Output result
		System.out.println("The future value is : " + futureValue);
				
		// Check to run calculation again
		System.out.println("Would you like to run the calculation again? (y/n):");
		calcAgain = scannerIn.next().charAt(0);
		//System.out.println(calcAgain);
		
	} while (calcAgain == 'y');
		
	}
}