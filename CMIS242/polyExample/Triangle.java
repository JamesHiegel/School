/*
 * the Triangle class is a subclass of Shape
 */

 public class Triangle extends Shape {

 	protected double base;
	protected double height;

 	public Triangle(double base, double height) {
		this.base= base;
		this.height = height;
		area = (0.5)*base*height;
	}

 }