/*
 * The Rectangle class implements ShapeInterface
 */


public class Rectangle implements ShapeInterface {

	protected double length;
	protected double width;

 	public Rectangle(double length, double width){
		this.length =length;
		this.width = width;
 	}

	/*
	 * All classes that implement the Shape interface
	 * must provide an implementation of the getArea() method
	 */
 	public double getArea() {
		return (length*width);
	}

} ///~