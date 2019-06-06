/*
* File: FamilyBudget.java
* Author: James Hiegel
* Date: 22 November 2015
* Purpose: This program sorts and outputs a
* family budget.
*/

import java.util.Arrays;
import java.util.Comparator;

public class FamilyBudget {

// month of year
static final int MONTHOFYEAR = 12;
// CATEGORY: 1-Groceries, 2-Utilities, 3-Insurance, 4-Fuel, 5-Clothes
static final int CATEGORY = 5;

    public static void main(String[] args) {
    // create 2d array
    double[][] familyBudget = new double[MONTHOFYEAR][CATEGORY];
        
    // fill with random values
    for (int x = 0; x < MONTHOFYEAR; x++) {
        for (int y = 0; y < CATEGORY; y++) {
        familyBudget[x][y] = Double.parseDouble(String.format("%.2f",Math.random() * 100));
        } //close y loop
    } // close x loop
    
    // print unsorted list
	System.out.println("Unsorted List:");
	for (int y = 0; y < CATEGORY; y++) {
            for (int x = 0; x < MONTHOFYEAR; x++) {
            System.out.print(familyBudget[x][y] + " | ");
            } // close x loop
	System.out.println("");  // new line
	} // close y loop  
    
    // sorts list by first row
	Arrays.sort(familyBudget, new Comparator<double[]>() {
		@Override
		public int compare(double[] o1, double[] o2) {
			return Double.compare(o2[0], o1[0]);
		}
	});

    // print sorted list
	System.out.println("");
	System.out.println("Sorted List:");
	for (int y = 0; y < CATEGORY; y++) {
            for (int x = 0; x < MONTHOFYEAR; x++) {
            System.out.print(familyBudget[x][y] + " | ");
            } // close x loop
	System.out.println("");  // new line
	} // close y loop  
	
    } // close main method
    
} // close class
