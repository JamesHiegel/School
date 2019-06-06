/*
* File: TestCircle2D.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs instances
* of the Circle2D
*/

public class TestCircle2D {	
    public static void main(String[] args)  { 

	// Construct an array of circles
        Circle2D[] circles= new Circle2D[5];
       
       // Construct using different parameters
      circles[0] = new Circle2D();
      // Radius input
      circles[1] = new Circle2D(2.0);
      // xCenter, ycenter input
      circles[2] = new Circle2D(1.5,2.5);
      // Fully parameterized
      circles[3] = new Circle2D(10.0,20.0,25.0);
      // Fully parameterized
      circles[4] = new Circle2D(3.0,3.0,4.0);
      // Display total number of Circles
      // I could have used any circle in the array to provide the same results
      System.out.println("Total Circles are: " + circles[2].getNumCircles() );

  
     // Loop through and display all data
     for (int i=0; i< circles.length; i++) {
       // Display xCenter, yCenter,Radius
       System.out.println("xCenter,yCenter,radius " + (i+1) + " = " + circles[i].getXCenter() +
           "," + circles[i].getYCenter() + "," + circles[i].getRadius());
       // Display Area with 1 as starting point
       System.out.println("Area " + (i+1) + " = " + circles[i].getArea());
      // Display Circumference
       System.out.println("Circumference " + (i+1) + " = " + circles[i].getCircumference());      
     }

    }

}