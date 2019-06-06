/*
* File: CircleScopeDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates the scope
* of class and local variables
*/

public class CircleScopeDemo {  
 // Define a static class variable
 // Hold number of objects
   private static int numCircles = 0;
 // Define class variable
   private double radius = 1.0;
      
  // Constructors
  // Default constructor
   public CircleScopeDemo() {        
        this.radius = 1.0;	
        numCircles++;
  }
  public CircleScopeDemo (double r) {
	radius = r;
        numCircles++;
  }
 
  // Area method
  public double getArea() {
     double area = Math.PI*Math.pow(radius,2);
     return area;
  }

  // getter method
  public double getRadius() {
     return radius;
  } 
  
  public static int getNumCircles() {
    return numCircles;
  } 
   
}