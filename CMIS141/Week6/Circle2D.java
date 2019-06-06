/*
* File: Circle2D.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs a Circle2D
* class along with appropriate fields
* constructors and methods
*/

public class Circle2D {  
 // Define a static class variable
 // Hold number of objects
   private static int numCircles = 0;
 // Define class variables
   private double radius = 1.0;
   private double xCenter = 0.0;
   private double yCenter = 0.0;

      
  // Constructors
  // Default constructor
   public Circle2D() {              
	this(0.0,0.0,1.0);       
  }
  // Fully parameterized constructor
  public Circle2D (double xCenter, double yCenter, double radius) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
	this.radius = radius;
        numCircles++;
  }
  // Partial parameterized constructor
  public Circle2D (double x, double y) {
        this(x,y, 1.0);
  }
  // Partial parameterized constructor
  public Circle2D (double radius) {
        this(0.0,0.0, radius);
  }
 
  // Area method
  public double getArea() {
     double area = Math.PI*(Math.pow(this.radius,2));
     return area;
  }

  // Circumference method
  public double getCircumference() {
     double circumference = 2.0*Math.PI*this.radius;
     return circumference;
  }

  // getter methods
  public double getRadius() {
     return this.radius;
  } 
  public double getXCenter() {
     return this.xCenter;
  } 
  public double getYCenter() {
     return this.yCenter;
  } 

 // setter methods
  public void setRadius(double radius) {
    this.radius = radius;
  }
   public void setXCenter(double xCenter) {
    this.xCenter = xCenter;
  }
   public void setYCenter(double yCenter) {
    this.yCenter = yCenter;
  }
  
  public static int getNumCircles() {
    return numCircles;
  } 
   
}