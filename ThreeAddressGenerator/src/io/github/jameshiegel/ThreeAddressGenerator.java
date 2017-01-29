package io.github.jameshiegel;

public class ThreeAddressGenerator {

	public static void main(String[] args) {

		ThreeAddGenView theView = new ThreeAddGenView();
		ThreeAddGenModel theModel = new ThreeAddGenModel();
		ThreeAddGenController theController = new ThreeAddGenController(theView, theModel);

		theView.setVisible(true);
	}

}
