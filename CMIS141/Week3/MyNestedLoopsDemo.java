/*
* File: MyNestedLoopsDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program calculates the sum of the 
* multiplication table from 11-99 and calculates
* the average.
*/

public class MyNestedLoopsDemo {	
    public static void main(String[] args)  { 

	// Define Number of Rows and Columns as Constants
	final int MAXROWS = 99;
	final int MAXCOLS = 99;
	final int MINROWS = 11;

 	System.out.println("");
	System.out.println("For Loop Nested Summation");
	int productSum = 0; 
	// need a counter for Average
	int loopCnt = 0;
	// Finally we use nested loops
	// And sum a variable to print the sum of products
	for (int rowCnt=MINROWS; rowCnt <= MAXROWS; rowCnt++) {	  
	  for (int colCnt=MINROWS; colCnt<= MAXCOLS; colCnt++) {
		productSum += rowCnt*colCnt;
		loopCnt++;	             
	   }	             
        }
	System.out.println("Product Sum is " + productSum );  
	System.out.println("Product Average is " + productSum/loopCnt);  
    }
}