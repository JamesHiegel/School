/*
 * the Triangle class implements ShapeInterface
 */

 public class Triangle implements ShapeInterface {

 	protected double base;
	protected double height;

 	public Triangle(double base, double height) {
		this.base= base;
		this.height = height;
	}

	/*
	 * All classes that implement the Shape interface
	 * must provide an implementation of the getArea() method
	 */
	public double getArea() {
		return ((0.5)*base*height);
	}
 } ///~