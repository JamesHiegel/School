/*
 * A test driver for our Interface example
 */

 public class InterfaceDriver {

 	public static void main(String[] args) {
		ShapeInterface[] shapeArray = new ShapeInterface[3];
		int index =0;

		// Error - cannot directly instantiate
		// ShapeInterface myShape = new ShapeInterface();

		ShapeInterface s = new Circle(1);
		shapeArray[index++] =s;

		s = new Rectangle(2,4);
		shapeArray[index++] = s;

		s = new Triangle(1,2);
		shapeArray[index++] = s;

		//print out all the areas in the array of ShapeInterface
		for(ShapeInterface shape : shapeArray) {
			System.out.println("The area of the shape is:"+shape.getArea());
			System.out.println("The type of this object is:"+shape.getClass().getName());
		}
	}

 } ///~