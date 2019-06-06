/*
* File: LoopsDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the use of Java's 
* repetition statements (while, do-while and for)
*/

// Import statements
import java.util.Scanner;

public class LoopsDemo {	
    public static void main(String[] args)  { 	
	int maxLoop = 0;
	
	System.out.println("Welcome to the Loops Demo");

	// Scanner class
	Scanner scannerIn = new Scanner (System.in);

	// Prompt use for how many random integers to generator
	System.out.println("How many integers to generate?");
	maxLoop = scannerIn.nextInt();
	
	// While Loop
	int cnt=0;
	int randInt = 0;
	while (cnt < maxLoop) {
	    randInt = (int) (Math.random() * 10);
	    System.out.println("While loop: Random value is " + randInt);
	    // Increment counter
            cnt++;
        }

	// Do while loop
	// Same logic but use the do while loop
	// Reset the counter
	cnt = 0;
	 do {
            randInt = (int) (Math.random() * 10);
	    System.out.println("do-while: Random value is " + randInt);
	     // Increment counter
             cnt++;
        } while (cnt < maxLoop);

	// For loop
	for (int i=0; i<maxLoop; i++) {
	    randInt = (int) (Math.random() * 10);
	     System.out.println("for loop: Random value is " + randInt);	    
	}

	// Break out of loop if count
	// if value == 9
	cnt=0;     
	while (cnt < maxLoop) {            
	    randInt = (int) (Math.random() * 10);
	    // print results if the random value is >= 5
	    if (randInt == 9) {    
		  System.out.println("Found the first 9. Exiting Loop!");           
		  break;		
	    }
	   System.out.println("End of Loop. Cnt is " + cnt);  
            cnt++;	                 
        }

	// Continue 
	// Continue if value ==9
	int totalCnt = 0;  
	int nineCnt = 0;  
       cnt = 0;
	while (cnt < maxLoop) {	 
	    totalCnt++;   
	    randInt = (int) (Math.random() * 10);
	    // print results if the random value is >= 5
	    if (randInt == 9) {   
		System.out.println("Found a 9. Continuing!");    
		nineCnt++;         
		continue;		
	    }
            System.out.println("End of Loop. Cnt is " + 
               cnt + "," + " Total Cnt is " + totalCnt +
               " Nine cnt is " + nineCnt);
            cnt++;	            
        }

	       
    }
}