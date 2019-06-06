/*
 * the Circle class is a subclass of Shape
 */

 public class Circle extends Shape {

 	protected double radius;

 	public Circle(double radius) {
		this.radius = radius;
		area = Math.PI * Math.pow(radius, 2);
	}

 }