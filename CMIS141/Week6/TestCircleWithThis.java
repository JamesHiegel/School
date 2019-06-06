/*
* File: TestCircleWithThis.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs instances
* of the CircleWithThis
*/

public class TestCircleWithThis {	
    public static void main(String[] args)  { 

	// Construct a default circle
        CircleWithThis circleLeft = new CircleWithThis();

	// Call the get values
	System.out.println("Circle left is: " + 
                circleLeft.getRadius());
        System.out.println("Number Circles is: " + 
               CircleWithThis.getNumCircles());
	System.out.println("Circle Left Area is: " + 
               String.format("%.2f",circleLeft.getArea()));

	// Construct another Circle
	CircleWithThis circleRight = new CircleWithThis(2.0);
	System.out.println("Circle Right is: " + 
              circleRight.getRadius());
        System.out.println("Number Circles is: " + 
              CircleWithThis.getNumCircles());
	System.out.println("Circle Right Area is: " + 
              String.format("%.2f",circleRight.getArea()));

	// Construct another Circle
	CircleWithThis circleCenter = new CircleWithThis(3.0);
	System.out.println("Circle Center is: " + 
               circleCenter.getRadius());
        System.out.println("Number Circles is: " + 
               CircleWithThis.getNumCircles());
	System.out.println("Circle Center Area is: " + 
               String.format("%.2f",circleCenter.getArea()));    	


    }

}