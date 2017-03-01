package io.github.jameshiegel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//James Hiegel, CMSC 350, Spring 2017, Project 3
/**
 * This class coordinates between the view and model.
 */
public class BSTController {
	private BSTView theView;
	private BSTModel theModel;

	public BSTController(BSTView theView, BSTModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		// tells theView what method to call when the button is clicked
		this.theView.addButtonListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// get the input from the view
			String input = theView.getOriginalList();
			try {
				// pass it to the model to build the tree
				if (theView.getNumberType() == true) {
					theModel.parseIntegerString(input);
				} else {
					theModel.parseFractionString(input);
				}
				
				String output = "";
				if (theView.getSort() == true) {
					output = theModel.ascendOrder();
				} else {
					output = theModel.descendOrder();
				}

				// pass the output to the view
				theView.setSortedList(output);
								
			} catch (RuntimeException e1) {
				// catches RunimeException errors and passed the error to a
				// pop-up window
				theView.displayErrorMessage("Error: " + e1.toString());
			}
		}
	}
}
