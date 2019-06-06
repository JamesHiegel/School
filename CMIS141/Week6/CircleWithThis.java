/*
* File: CircleWithThis.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the 
* use of the this reference
*/

public class CircleWithThis {  
 // Define a static class variable
 // Hold number of objects
   private static int numCircles = 0;
 // Define class variable
   private double radius = 1.0;
      
  // Constructors
  // Default constructor
   public CircleWithThis() {        
        this(1.0);	        
  }
  public CircleWithThis (double r) {
	this.radius = r;
        numCircles++;
  }
 
  // Area method
  public double getArea() {
     double area = Math.PI*Math.pow(radius,2);
     return area;
  }

  // getter method
  public double getRadius() {
     return this.radius;
  } 
  
  public static int getNumCircles() {
    return numCircles;
  } 
   
}