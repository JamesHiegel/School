package io.github.jameshiegel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreeAddGenController {

	private ThreeAddGenView theView;
	private ThreeAddGenModel theModel;

	public ThreeAddGenController(ThreeAddGenView theView, ThreeAddGenModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		this.theView.addCalculationListener(new CalculateListener());

	}

	class CalculateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int firstNumber, secondNumber = 0;

			try {
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.addTwoNumbers(firstNumber, secondNumber);

				theView.setCaclSolution(theModel.getCalculationValue());
			} catch (NumberFormatException ex) {
				theView.displayErrorMessage("You need to enter two integers!");
			}
		}
	}
}