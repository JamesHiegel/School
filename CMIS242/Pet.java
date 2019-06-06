/*
* File: Pet.java
* Author: James Hiegel
* Date: 01/20/2016
* Purpose: This program demonstrates a superclass and subclass, and overriding of methods.
*/
public class Pet {  //superclass
	// Variables
	protected int age = 0;
	protected String gender = "";
	protected String furColor = "";
	protected String superOutput = "";
	
	// Constructor
	public Pet(int ag, String gen, String fur) {
		age = ag;
		gender = gen;
		furColor = fur;
	}
	
	// Overrides toString() method
	@Override
	public String toString() {
		superOutput = age + ", " + gender + ", " + furColor;
		return superOutput;
	}
}
 
class Cat extends Pet {  //subclass
	// Variables
	private String breed = "";
	private String furPattern = "";
	private String subOutput = "";
	
	public Cat(int ag, String gen, String fur, String bre, String pat) {
		super(ag, gen, fur);
		breed = bre;
		furPattern = pat;
		System.out.toString();
	}
	
	// Overrides toString() method
	@Override
	public String toString() {
		subOutput = super.toString() + "," + breed + ", " + furPattern;
		return subOutput;
	}
}
 
class MainClass {
	
	public static void main(String args[]) {
		
		Pet puppy = new Pet(1,"male","white");
		Cat kitten = new Cat(2,"female","grey","Tabby","spots");
		System.out.println("Cat toString() method: " + kitten.toString());
		System.out.println("Pet toString() method: " + puppy.toString());

	}
}