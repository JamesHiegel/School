/*
 * the Circle class implements the Shape interface
 */

 public class Circle implements ShapeInterface {

 	protected double radius = 0;

 	public Circle(double radius) {
		this.radius = radius;

	}

	/*
	 * All classes that implement the Shape interface
	 * must provide an implementation of the getArea() method
	 */
	public double getArea() {
		return(Math.PI * Math.pow(radius, 2));
	}

 }///~