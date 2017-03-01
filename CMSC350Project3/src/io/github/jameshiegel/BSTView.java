package io.github.jameshiegel;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

//James Hiegel, CMSC 350, Spring 2017, Project 2
/**
 * This class creates the user interface, returns the inputed string, changes
 * the output text box, calls the appropriate method when the button is pressed
 * and displays an error message pop-up.
 */
public class BSTView extends JFrame {
	// create all components
	private final static int HEIGHT = 300;
	private final static int WIDTH = 400;
	private JLabel inputTitle = new JLabel("Original List");
	private JTextField inputTextBox = new JTextField(20);
	private JLabel outputTitle = new JLabel("Sorted List");
	private JTextField outputTextBox = new JTextField(02);
	private JButton sortBtn = new JButton("Perform Sort");
	private JRadioButton ascendSort = new JRadioButton("Ascending");
	private JRadioButton descendSort = new JRadioButton("Descending");
	private ButtonGroup sortOrder = new ButtonGroup();
	private JRadioButton integerType = new JRadioButton("Integer");
	private JRadioButton fractionType = new JRadioButton("Fraction");
	private ButtonGroup numericType = new ButtonGroup();

	/**
	 * This method creates the GUI.
	 */
	BSTView() {
		this.setTitle("Binary Tree Search Sort");

		// terminates the program on window close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);// centers window on screen

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 0);

		// creates top panel
		JPanel topPanel = new JPanel(new GridBagLayout());

		// add components to top panel
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = 1;
		topPanel.add(inputTitle, c);

		c.gridy = 0;
		c.gridx = 1;
		c.ipadx = 225;
		topPanel.add(inputTextBox, c);

		JLabel spacer1 = new JLabel(" ");
		c.gridy = 1;
		c.gridx = 1;
		c.ipadx = 0;
		topPanel.add(spacer1, c);

		c.gridy = 2;
		c.gridx = 0;
		c.ipadx = 0;
		topPanel.add(outputTitle, c);

		c.gridy = 2;
		c.gridx = 1;
		c.ipadx = 225;
		topPanel.add(outputTextBox, c);
		outputTextBox.setEditable(false); // makes output text box uneditable

		JLabel spacer2 = new JLabel(" ");
		c.gridy = 3;
		c.gridx = 1;
		c.ipadx = 0;
		topPanel.add(spacer2, c);

		c.gridy = 4;
		c.gridx = 1;
		c.ipadx = 0;
		topPanel.add(sortBtn, c);

		JLabel spacer3 = new JLabel(" ");
		c.gridy = 5;
		c.gridx = 1;
		c.ipadx = 0;
		topPanel.add(spacer3, c);

		// adds buttons to button groups
		sortOrder.add(ascendSort);
		ascendSort.setSelected(true);// default selection
		sortOrder.add(descendSort);
		numericType.add(integerType);
		integerType.setSelected(true);// default selection
		numericType.add(fractionType);

		// creates panels to hold buttons
		JPanel sortPanel = new JPanel(new GridLayout(2, 1));
		sortPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sort Order"));
		sortPanel.add(ascendSort);
		sortPanel.add(descendSort);
		JPanel typePanel = new JPanel(new GridLayout(2, 1));
		typePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Numeric Type"));
		typePanel.add(integerType);
		typePanel.add(fractionType);

		// adds button panels to bottom panel
		JPanel btmPanel = new JPanel(new GridLayout(1, 2));
		btmPanel.add(sortPanel);
		btmPanel.add(typePanel);

		// adds bottom panel to top panel
		c.gridy = 6;
		c.gridx = 0;
		c.gridwidth = 3;
		c.ipadx = 150;
		topPanel.add(btmPanel, c);

		this.add(topPanel);
	}

	/**
	 * This method returns the text inputed into the Original List text box.
	 * 
	 * @return the String inputed in the Original List text box
	 */
	public String getOriginalList() {
		return inputTextBox.getText();
	}
	
	public boolean getSort() {
		return ascendSort.isSelected() ==  true;
	}
	
	public boolean getNumberType() {
		return integerType.isSelected() == true;
	}
	
	/**
	 * This method changes the text in the Sorted List text box.
	 * 
	 * @param textMessage
	 *            the String to be put in the Sorted List text box.
	 */
	public void setSortedList(String textMessage) {
		outputTextBox.setText(textMessage);
	}
	
	/**
	 * This method listens for a user to press the button and then executes an
	 * action listener method in the controller
	 * 
	 * @param listenForButton
	 */
	void addButtonListener(ActionListener listenForButton) {
		sortBtn.addActionListener(listenForButton);
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