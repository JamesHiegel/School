/*
* File: Lottery.java
* Author: James Hiegel
* Date: 11/15/2015
* Purpose: This program contains the Lottery Class.
*/

import java.util.*;

public class Lottery {    
	private int rngMin;
	private int rngMax;
   
    // Constructor
    public Lottery (int min, int max) { 
	rngMin = min;
	rngMax = max;
    }

   // Default constructor
    public Lottery () {		
	rngMin = 1;
	rngMax = 10;    
    }
    
    // Setter methods 
    // setMin
    public void setMin(int min) {
	rngMin = min;
    }
    // setMax
    public void setMax(int max) {
	rngMax = max;
    }
	
   // Getter methods
   // getMin
    public int getMin() {
	return rngMin;
    }  
	// getMax
    public int getMax() {
	return rngMax;
    }  
 
    // getPicks
    public int getPicks() {
	int pickResult = 0;
	Random randNum = new Random();
	return pickResult = (randNum.nextInt(rngMax - rngMin + 1) + rngMin);
    }  
}