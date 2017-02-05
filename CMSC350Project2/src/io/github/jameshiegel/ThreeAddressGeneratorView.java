package io.github.jameshiegel;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

//James Hiegel, CMSC 350, Spring 2017, Project 2
/**
 * This class creates the user interface, returns the postfix expression string,
 * changes the infix text box, calls a method when the button is pressed and
 * displays an error message pop-up.
 */
public class ThreeAddressGeneratorView extends JFrame {
	// create all components
	private JLabel postfixTitle = new JLabel("Enter Postfix Expression");
	private JTextField postfixExp = new JTextField(16);
	private JButton constructBtn = new JButton("Construct Tree");
	private JLabel infixTitle = new JLabel("Infix Expression");
	private JTextField infixExp = new JTextField(16);
	private final static int HEIGHT = 150;
	private final static int WIDTH = 400;

	/**
	 * This method creates the GUI.
	 */
	ThreeAddressGeneratorView() {
		JPanel panel = new JPanel(new GridBagLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// terminates the
															// program on window
															// close
		this.setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);// centers window on screen

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 0);

		// add components to GUI
		c.gridy = 0;
		c.gridx = 0;
		panel.add(postfixTitle, c);

		c.gridy = 0;
		c.gridx = 1;
		c.gridwidth = 2;
		c.ipadx = 225;
		panel.add(postfixExp, c);

		c.gridy = 1;
		c.gridx = 1;
		c.gridwidth = 1;
		c.ipadx = 0;
		panel.add(constructBtn, c);

		c.gridy = 2;
		c.gridx = 0;
		c.gridwidth = 1;
		panel.add(infixTitle, c);
		infixExp.setEditable(false); // make infix box uneditable

		c.gridy = 2;
		c.gridx = 1;
		c.gridwidth = 2;
		c.ipadx = 225;
		panel.add(infixExp, c);

		this.setTitle("Three Address Generator");
		this.add(panel);
	}

	/**
	 * This method returns the text inputted into the postfix expression text
	 * box.
	 * 
	 * @return the String inputted in the postfix text box
	 */
	public String getPostFixExpression() {
		return postfixExp.getText();
	}

	/**
	 * This method changes the text in the infix text box.
	 * 
	 * @param textMessage
	 *            the String to be put in the infix text box.
	 */
	public void setInFixExpression(String textMessage) {
		infixExp.setText(textMessage);
	}

	/**
	 * This method listens for a user to press the button and then executes an
	 * action listener method in the controller
	 * 
	 * @param listenForButton
	 */
	void addButtonListener(ActionListener listenForButton) {
		constructBtn.addActionListener(listenForButton);
	}

	/**
	 * This method displays an error message in a pop-up window.
	 * 
	 * @param errorMessage
	 *            the String to be displayed.
	 */
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
