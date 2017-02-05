package io.github.jameshiegel;

//James Hiegel, CMSC 350, Spring 2017, Project 2
/**
 * This the main class that creates the model and view, and then passes them to the controller.
 */
public class ThreeAddressGenerator {

	public static void main(String[] args) {
		ThreeAddressGeneratorView theView = new ThreeAddressGeneratorView();
		ThreeAddressGeneratorModel theModel= new ThreeAddressGeneratorModel();
		ThreeAddressGeneratorController theController= new ThreeAddressGeneratorController(theView, theModel);
		
		theView.setVisible(true);
	}

}
