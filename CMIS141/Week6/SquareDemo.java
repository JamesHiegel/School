/*
* File: SquareDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs Square
* class for demo of local and class scope
*/

public class SquareDemo {  
 // Define a static class variable
 // Hold number of objects
   private static int numSquares = 0;
 // Define class variable
   private double length = 1.0;
      
  // Constructors
  // Default constructor
   public SquareDemo() {        
        this.length = 1.0;	
        numSquares++;
  }
  public SquareDemo (double r) {
	length = r;
        numSquares++;
  }
 
  // Area method
  public double getArea() {
     double area = Math.pow(length,2);
     return area;
  }

  // Perimeter method
  public double getPerimeter() {
     double perimeter = length*4;
     return perimeter;
  }

  // getter method
  public double getLength() {
     return length;
  } 

 // setter method
  public void setLength(double length) {
    this.length = length;
  }
  
  public static int getNumSquares() {
    return numSquares;
  } 
   
}