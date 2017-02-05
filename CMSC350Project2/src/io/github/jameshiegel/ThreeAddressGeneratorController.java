package io.github.jameshiegel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//James Hiegel, CMSC 350, Spring 2017, Project 2
/**
 * This class coordinates between the view and model.
 */
public class ThreeAddressGeneratorController {
	private ThreeAddressGeneratorView theView;
	private ThreeAddressGeneratorModel theModel;

	public ThreeAddressGeneratorController(ThreeAddressGeneratorView theView, ThreeAddressGeneratorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		// tells theView what method to call when the button is clicked
		this.theView.addButtonListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// get the postfix expression from the view
			String input = theView.getPostFixExpression();

			try {
				// pass it to the model to build the tree and create the infix
				// expression
				String output = theModel.constructTree(input);
				// pass the infix expression to the view
				theView.setInFixExpression(output);

			} catch (RuntimeException e1) {
				String errorMsg = e1.toString();
				String invalidToken = errorMsg.substring(errorMsg.length() - 1, errorMsg.length());
				theView.displayErrorMessage("Invalid token: " + invalidToken);
			}
		}
	}
}
