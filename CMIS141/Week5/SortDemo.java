/*
* File: SortDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates how to sort
* primitives using the selection sort
* and the Arrays quick sort algorithm
*/

// Import Color class
import java.util.Arrays;

public class SortDemo {  
// Define constant array size
static final int ARRAYSIZE = 10;

// Method from Notes for Selection Sort
 public static void selectionSort(int[] array) {
       // Iterate for each position in the array. Note
       // that because <  (not <= ) is used,
       // i < (array.length - 1) iterates
       // i from 0 to (array.length - 2).
       for (int i = 0; i < (array.length - 1); i++) {

          int min = i;  

          // Find the smallest value in the array. Note that
          // after each pass, the smallest value is in place,
          // so the loop starts at the position following
          // the last pass in the loop.
          for (int j = i; j < (array.length); j++) {
            if (array[j] < array[min])
               min = j;
          } // end for

          // Swap the next selected array position
          // with the smallest value found on this pass.
          int temp = array[min];
          array[min] = array[i];
          array[i] = temp;
      } // end for
   } // end method
   
     // Main method
    public static void main(String args[]){
      System.out.println("Welcome to the Array Demo");

     // Create array of ints
      int[] intValues = new int[ARRAYSIZE];
	// Assign random values 
       for (int i=0; i<intValues.length; i++) {
	 intValues[i] = (int) (Math.random() * 100);         
       }
	System.out.println("******Unsorted int array*******");
	// Print the unsorted array
	for (int i=0; i<intValues.length; i++) {
	 System.out.println(intValues[i]) ;        
       }
	System.out.println("*****************************");

      // Call the Selection Sort method
	selectionSort(intValues);

	System.out.println("******Sorted int array*******");
	// Print the sorted array
	for (int i=0; i<intValues.length; i++) {
	 System.out.println(intValues[i]);         
       }
	System.out.println("*****************************");
     
	// Generate an array of doubles
	double[] doubleValues = new double[ARRAYSIZE];
	// Assign random values 
       for (int i=0; i<doubleValues.length; i++) {
	 doubleValues[i] = (Math.random() * 100);         
       }

	System.out.println("******Unsorted double array*******");
	// Print the unsorted array
	for (int i=0; i<doubleValues.length; i++) {
	 System.out.println(doubleValues[i]) ;        
       }
	System.out.println("*****************************");
	// Sort the double value	
         Arrays.sort(doubleValues);

	System.out.println("******Sorted double array*******");
	// Print the sorted array
	for (int i=0; i<doubleValues.length; i++) {
	 System.out.println(doubleValues[i]) ;        
       }
	System.out.println("*****************************");
	

    }
   
    
   
}