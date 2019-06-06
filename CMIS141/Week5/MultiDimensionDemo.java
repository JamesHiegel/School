/*
* File: MultiDimensionDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates how to create
* and populate 2D and 3D arrays in Java
*/


public class MultiDimensionDemo {  
// Define constant array size
static final int NUMYEARS = 7;
static final int NUMMONTHS = 12;
static final int NUMDAYS = 31;

   
     // Main method
    public static void main(String args[]){
      System.out.println("Welcome to the MultiDimensional Array Demo");

     // Create array of doubles 2 D
      double[][] precip2D = new double[NUMMONTHS][NUMDAYS];
	// Assign random values 
       for (int i=0; i<NUMMONTHS; i++) {
          for (int j=0; j<NUMDAYS; j++) {
	      precip2D[i][j] = Double.parseDouble(String.format("%.2f",Math.random() * 10));    
          }     
       }
	
      // Print the results for each cell in a table 31x12
      // Switching the printing order to display months in columns
      for (int j=0; j<NUMDAYS; j++) {
          for (int i=0; i<NUMMONTHS; i++) {
	      System.out.print(precip2D[i][j] + "\t"); 
          }
	    System.out.println("");     
       }

     // Create array of doubles 3D
      double[][][] precip3D = new double[NUMYEARS][NUMMONTHS][NUMDAYS];
	// Assign random values 
       for (int k=0; k<NUMYEARS; k++) {
         for (int i=0; i<NUMMONTHS; i++) {
            for (int j=0; j<NUMDAYS; j++) {
	      precip3D[k][i][j] = Double.parseDouble(String.format("%.2f",Math.random() * 10));    
            }
         }     
       }

     // Print results with Year upfront
     // Define BaseYear
	int baseYear = 2000;
	for (int k=0; k<NUMYEARS; k++) {
	   System.out.println("Year is " + (baseYear+k)); 
	  for (int j=0; j<NUMDAYS; j++) {   
            for (int i=0; i<NUMMONTHS; i++) {                       
	      System.out.print(precip3D[k][i][j] + "\t");    
            }
              System.out.println(""); 
          }                        
        }

	

    }
   
    
   
}