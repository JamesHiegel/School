/*
 * A test driver for our polymorphism example
 */

 public class Polydriver {

 	public static void main(String[] args) {
		Shape[] shapeArray = new Shape[3];
		int index =0;

		// Error - cannot directly instantiate an abstract class
		// Shape myShape = new Shape();

		Shape s = new Circle(1);
		shapeArray[index++] =s;

		s = new Rectangle(2,4);
		shapeArray[index++] =s;

		s = new Triangle(1,2);
		shapeArray[index++] =s;

		//print out all the areas in the array of Shape
		for(Shape shape : shapeArray) {
			System.out.println("The area of the shape is:"+shape.getArea());
		}
	}



 }