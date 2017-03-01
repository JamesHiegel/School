package io.github.jameshiegel;

public class BinarySearchTree {

	public static void main(String[] args) {

		BSTView theView = new BSTView();
		BSTModel theModel= new BSTModel();
		BSTController theController= new BSTController(theView, theModel);
		
		theView.setVisible(true);
	}

}
