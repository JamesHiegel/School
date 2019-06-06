/*
* File: SquareThisDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs Square
* class for demo of local and class scope
* using this references
*/

public class SquareThisDemo {  
 // Define a static class variable
 // Hold number of objects
   private static int numSquares = 0;
 // Define class variable
   private double length = 1.0;
      
  // Constructors
  // Default constructor
   public SquareThisDemo() {              
	this(1.0);       
  }
  public SquareThisDemo (double r) {
	length = r;
        numSquares++;
  }
 
  // Area method
  public double getArea() {
     double area = Math.pow(this.length,2);
     return area;
  }

  // Perimiter method
  public double getPerimeter() {
     double perimeter = this.length*4;
     return perimeter;
  }

  // getter method
  public double getLength() {
     return this.length;
  } 

 // setter method
  public void setLength(double length) {
    this.length = length;
  }
  
  public static int getNumSquares() {
    return numSquares;
  } 
   
}