/*
 * The Rectangle class is a subclass of Shape
 */


public class Rectangle extends Shape {

	protected double length;
	protected double width;

 	public Rectangle(double length, double width){
		this.length =length;
		this.width = width;
		area = length * width;
 	}

}