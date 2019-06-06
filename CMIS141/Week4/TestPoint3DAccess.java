/*
* File: TestPoint3DAccess.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs instances
* of the Point3D class and uses
* its methods
*/

public class TestPoint3DAccess {	
    public static void main(String[] args)  { 

	// Construct a point with 4.0, 3.0, -2.0
        Point3DAccess p1 = new Point3DAccess(4.0, 3.0, -2.0);
     
	// Construct a default point
	Point3DAccess p2 = new Point3DAccess();	

	// Call the getter methods
	double p1X = p1.getX();
	double p1Y = p1.getY();
	double p1Z = p1.getZ();
	// Print results
	System.out.println("p1 values from getX() getY() getZ() " + 
                             p1X + "," + p1Y + "," + p1Z);

	double p2X = p2.getX();
	double p2Y = p2.getY();
        double p2Z = p2.getZ();
	// Print results
	System.out.println("p2 values from getX() getY() getZ()" + 
                             p2X + "," + p2Y + "," + p2Z);

	// Call the Distance Method
	double distance = p1.getDistance(p1,p2);
	// Print results
	System.out.println("3D Distance between p1 and p2 is: " + 
                             distance);
	// Change the XY value of P1
	// Using the setter method
	double newX = 8.0;
	double newY = 22.0;
        double newZ = 52.0;
	//p1.setX(newX);
	//p1.setY(newY);
        //p1.setZ(newZ);

	// Recalculate the Distance
	distance = p1.getDistance(p1,p2);
	// Print results
	System.out.println("New 3D Distance between p1 and p2 is: " + 
                             distance);
	// Display the values using toString
	System.out.println(p1.toString());
	System.out.println(p2.toString());
	// Display directly the x,y and z values
	System.out.println("direct values " + p1.x + "," +
                            p1.y + "," + p1.z + "," + p2.x + 
                            p2.y + "," + p2.z);


    }

}