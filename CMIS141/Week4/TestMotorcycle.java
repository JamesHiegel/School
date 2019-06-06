/*
* File: TestMotorcycle.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs instances
* of the Point class and uses
* its methods
*/

public class TestMotorcycle {	
    public static void main(String[] args)  { 

	// Construct a six speed 2008 Harley-Davidson Softtail Custom
        Motorcycle bike1 = new Motorcycle("Harley-Davidson","Softtail Custom",2008,6);
     
	// Construct a default motorcycle
	Motorcycle bike2 = new Motorcycle();	

	// Call the getter methods
	int bikeYear = bike1.getYear();
	String bikeMake = bike1.getMake();
	String bikeModel = bike1.getModel();
	int bikeGears = bike1.getGears();
	// Print results
	System.out.println("Bike 1 is a " + bikeGears + " speed " + bikeYear + " " + bikeMake + " " + bikeModel + ".");

	bikeYear = bike2.getYear();
	bikeMake = bike2.getMake();
	bikeModel = bike2.getModel();
	bikeGears = bike2.getGears();
	// Print results
	System.out.println("Bike 2 is a " + bikeGears + " speed " + bikeYear + " " + bikeMake + " " + bikeModel + ".");
	
	int ageDiff = 0;
	
	if (bike1.getYear() > bike2.getYear()) {
		ageDiff	= bike1.getYear() - bike2.getYear();
		System.out.println("Bike 2 is " + ageDiff + " years older than Bike 1.");
	}else{
		ageDiff	= bike2.getYear() - bike1.getYear();
		System.out.println("Bike 1 is " + ageDiff + " years older than Bike 2.");
	}
	}
}