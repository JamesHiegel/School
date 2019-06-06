/*
* File: TestSquareThisDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs instances
* of the SquareThisDemo
*/

public class TestSquareThisDemo {	
    public static void main(String[] args)  { 

	// Construct a default square
        SquareThisDemo squareLeft = new SquareThisDemo();

	// Call the get values
	System.out.println("Square left is: " + 
                squareLeft.getLength());
        System.out.println("Number Squares is: " + 
               SquareDemo.getNumSquares());
	System.out.println("Square Left Area is: " + 
               String.format("%.2f",squareLeft.getArea()));
        System.out.println("Square Left Perimeter is: " + 
               String.format("%.2f",squareLeft.getPerimeter()));

	// Construct another Square
        SquareThisDemo squareRight = new SquareThisDemo(2.0);

	// Call the get values
	System.out.println("Square Right is: " + 
                squareRight.getLength());
        System.out.println("Number Squares is: " + 
               squareRight.getNumSquares());
	System.out.println("Square Left Area is: " + 
               String.format("%.2f",squareRight.getArea()));
        System.out.println("Square Left Perimeter is: " + 
               String.format("%.2f",squareRight.getPerimeter()));

	// Construct another Square
        SquareThisDemo squareCenter = new SquareThisDemo(3.0);

	// Call the get values
	System.out.println("Square Center is: " + 
                squareCenter.getLength());
        System.out.println("Number Squares is: " + 
               squareCenter.getNumSquares());
	System.out.println("Square Center Area is: " + 
               String.format("%.2f",squareCenter.getArea()));
        System.out.println("Square Center Perimeter is: " + 
               String.format("%.2f",squareCenter.getPerimeter()));	

	// Construct another Square
        SquareThisDemo squareUp = new SquareThisDemo(4.0);

	// Call the get values
	System.out.println("Square Up is: " + 
                squareUp.getLength());
        System.out.println("Number Squares is: " + 
               squareUp.getNumSquares());
	System.out.println("Square Up Area is: " + 
               String.format("%.2f",squareUp.getArea()));
        System.out.println("Square Up Perimeter is: " + 
               String.format("%.2f",squareUp.getPerimeter()));	

	// Construct another Square
        SquareThisDemo squareDown = new SquareThisDemo(5.0);

	// Call the get values
	System.out.println("Square Down is: " + 
                squareDown.getLength());
        System.out.println("Number Squares is: " + 
               squareDown.getNumSquares());
	System.out.println("Square Down Area is: " + 
               String.format("%.2f",squareDown.getArea()));
        System.out.println("Square Down Perimeter is: " + 
               String.format("%.2f",squareDown.getPerimeter()));	

    }

}