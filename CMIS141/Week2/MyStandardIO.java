// Import each required Java class
import java.util.Scanner;

/**
 * MY Standard I/O Demo
 */
public class MyStandardIO {	
    public static void main(String[] args) { 
	// Variables to hold values
	byte age = 0;
	float latitude = 0.0f;
	float longitude = 0.0f;
	long starCount = 0L;
	short maxShort = 0;
	boolean stressedOut = true;
		
      	// Use the Scanner class to input data from Standard I/O
        Scanner scannerIn = new Scanner(System.in);

	// Prompt the user to enter their age
	System.out.println("Enter your age:");	
        age = scannerIn.nextByte();

	// Prompt the user to enter the latitude of their address
	System.out.println("Enter the latitude of your address:");	
        latitude = scannerIn.nextFloat();

	// Prompt the user to enter the longitude of their address
	System.out.println("Enter the longitude of your address:");	
        longitude = scannerIn.nextFloat();

	// Prompt the user to enter the number of stars in our galaxy
	System.out.println("Enter the number of stars in our galaxy:");	
        starCount = scannerIn.nextLong();

	// Prompt the user to enter the maximum short value
	System.out.println("Enter the maximum value possible for a Java short value:");	
        maxShort = scannerIn.nextShort();

	// Prompt the user to enter true or false to if your stressed out
	System.out.println("I am stressed out! (true or false):");	
        stressedOut = scannerIn.nextBoolean();

	// Display all results to Standard Output
	System.out.println("age is :" + age);
	System.out.println("latitude is :" + latitude);
	System.out.println("longitude is :" + longitude);
	System.out.println("starCount is :" + starCount);
	System.out.println("maxShort is :" + maxShort);	
	System.out.println("stressedOut is :" + stressedOut);	
	
    }
}
