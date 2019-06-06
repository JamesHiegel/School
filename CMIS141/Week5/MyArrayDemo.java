/*
* File: MyArrayDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the creation
* and use of Java arrays
*/

// Import the Random
import java.util.Random;

public class MyArrayDemo {  
// Define constant array size
static final int INTARRAYSIZE = 50;
static final int BOOLEANARRAYSIZE = 100;
   
       // Main method
    public static void main(String args[]){
      System.out.println("Welcome to MY Array Demo");

     // Create array of ints
      int[] intValues = new int[INTARRAYSIZE];
	// Assign random values 
       for (int i=0; i<intValues.length; i++) {
	 intValues[i] = (int) (Math.random() * 101) - 50;         
       }

	 // Create array of Booleans
 	Boolean[] booleanValues = new Boolean[BOOLEANARRAYSIZE];
	Random randomB = new Random();
	// Assign random values 
       for (int i=0; i<booleanValues.length; i++) {
	 booleanValues[i] = randomB.nextBoolean();        
       }
	
	
	// Display the results
	System.out.println("int values");
	for (int i=0; i<intValues.length; i++) {
            // Print new line every 10 items
            if ((i % 10)==0  ) {
		System.out.println("");
            }
	System.out.print(intValues[i] +"\t");
	}
	
	System.out.println("");
	System.out.println("Boolean values");
	for (int i=0; i<booleanValues.length; i++) {
            // Print new line every 10 items
            if ((i % 10)==0  ) {
		System.out.println("");
            }	  
	   System.out.print(booleanValues[i] + "\t");
	}

	
    }
   
    
   
}