
/*
* File: ThreeMotorcycles.java
* Author: James Hiegel
* Class: CMIS 242
* Date: 1/17/2016
* Purpose: This class creates three motorcycle objects to show the difference between class and instance
* variables.
*/
public class ThreeMotorcycles {
	// Class variables
	public static int numWheels = 2;
	
	public static void main(String[] args) {
		
		Motorcycle bike1 = new Motorcycle (2008, "Harley-Davidson", "Softtail Custom", 1584, 6);
		System.out.println(bike1.toString());
		Motorcycle bike2 = new Motorcycle (2013, "Kawasaki", "Ninja 1000", 1043, 6);
		System.out.println(bike2.toString());
		Motorcycle bike3 = new Motorcycle (2016, "BMW", "F700GS", 798, 6);
		System.out.println(bike3.toString());
	}

}
