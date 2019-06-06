/*
* File: Point3DAccess.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program constructs instances
* of the Point class and uses
* its methods
*/

public class Point3DAccess {    
    public double x;
    public double y;
    public double z;

    // Constructor
    public Point3DAccess (double px, double py, double pz) { 
	x = px;
	y = py;	
	z = pz;
    }

   // Default constructor
    public Point3DAccess () {		
	x = 1.0;
	y = -1.0;      
	z = -1.0;
    }
    
    // Setter methods 
    // setX
    private void setX(double px) {
	x = px;
    }
    // setY()
   private void setY(double py)  {	
	y = py;
    }
  // setZ()
   private void setZ(double pz)  {	
	z = pz;
    }
	
   // Getter methods
   // getX
    public double getX() {
	return x;
    }    
    // getY
    public double getY() {
	return y;
    }
   // getZ
    public double getZ() {
	return z;
    }

   
    // Use Math method to get the distance
    // between 2 points
    public double getDistance(Point3DAccess p1, Point3DAccess p2) {
      // delta x
      double deltaX = Math.abs(p1.getX() - p2.getX());
      // delta y
      double deltaY = Math.abs(p1.getY() - p2.getY());
      // delta z     
      double deltaZ = Math.abs(p1.getZ() - p2.getZ());

      // Distance formula
      double distance = Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);
      return distance;
    }

  
    // toString method
    public String toString() {
	String str = "(" + x + ", " + y +  "," + z + ")";
	return str; 
    }
   
}