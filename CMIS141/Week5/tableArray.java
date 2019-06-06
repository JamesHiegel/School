/*
* File: tableArray.java
* Author: James Hiegel
* Date: 22 November 2015
* Purpose: This program will create a 10 column by 5 row array 
* with random numbers and then output them to a table.
*/

import java.util.Random;

public class tableArray {

	public static void main(String args[]) {
		// create array
		int[][] intArray = new int[10][5];
	
		// fill array with random numbers
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				intArray[x][y] = (int)(Math.random() * 101) - 50;         
			} // close y loop
		} // close x loop
		
		// print results
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 10; x++) {
				System.out.print(intArray[x][y] + " | ");
			} // close x loop
		System.out.println("");  // new line
		} //close y loop
	}
}