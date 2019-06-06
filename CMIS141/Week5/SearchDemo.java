/*
* File: SearchDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates how to search
* primitives using the 
* Arrays binary search algorithm
*/

// Import Color class
import java.util.Arrays;

public class SearchDemo {  
// Define constant array size
static final int ARRAYSIZE = 100;

   
     // Main method
    public static void main(String args[]){
      System.out.println("Welcome to the Search Demo");

     // Create array of ints
      int[] intValues = new int[ARRAYSIZE];
	// Assign random values 
       for (int i=0; i<intValues.length; i++) {
	 intValues[i] = (int) (Math.random() * 50);         
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
	// Remember we must sort before we can search
	// when using a binary search approach
	int lookFor = 11;

	int arrIndex = Arrays.binarySearch(intValues,lookFor);
	
    	System.out.println("The index with value 11 is : " + arrIndex);	

    }
   
    
   
}