/*
* File: MySearchDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates how to search
* primitives using the 
* Arrays binary search algorithm
*/

// Import Color class
import java.util.Arrays;
import java.util.Scanner;

public class MySearchDemo {  
// Define constant array size
static final int ARRAYSIZE = 20;

   
     // Main method
    public static void main(String args[]){
      System.out.println("Welcome to the Search Demo");

     // Create array of ints
      int[] intValues = new int[ARRAYSIZE];
	// Assign random values 
       for (int i=0; i<intValues.length; i++) {
	 intValues[i] = (int) (Math.random() * 100)+1;         
       }
	System.out.println("******Unsorted int array*******");
	// Print the unsorted array
	for (int i=0; i<intValues.length; i++) {
	 System.out.println(intValues[i]) ;        
       }
	System.out.println("*****************************");

     	// Sort the int array value	
         Arrays.sort(intValues);

	System.out.println("******Sorted int array*******");
	// Print the sorted array
	for (int i=0; i<intValues.length; i++) {
	 System.out.println("index is " + i + "," + "value is " + intValues[i]) ;        
       }
	System.out.println("*****************************");
	
	// Now we can search
	// Prompt user for value to search
	// Construct a Scanner class
        Scanner scannerIn = new Scanner(System.in);

	// Prompt user for age and avgScore
	System.out.println("Enter the value to search (e.g. 30) ");
	// Scan the next String and parse the Integer value
	int lookFor = Integer.parseInt(scannerIn.next());	

	int arrIndex = Arrays.binarySearch(intValues,lookFor);
	
	// Print the results
	if (arrIndex > 0) {	
    	   System.out.println("The index with value " + lookFor + "is : " + arrIndex);	
	}
	else {	
	   System.out.println("No value was found");	
	}

    }
   
    
   
}