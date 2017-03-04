package io.github.jameshiegel;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

//James Hiegel, CMSC 350, Spring 2017, Project 4
/**
 * This class creates and displays the graphic user interface, and provides
 * methods that return the "Input file name" and "Class to recompile" text
 * boxes, change the "Recompilation order" text box, action listeners for the
 * "Build Directed Graph" and "Topological Order" buttons, and a pop up window.
 */
public class CDGView extends JFrame {
	// create all components
	private final static int HEIGHT = 300;
	private final static int WIDTH = 550;

	private JLabel inputFileNameLabel = new JLabel("Input file name:");
	private JTextField inputFileName = new JTextField(15);
	private JButton buildDirectedGraphBtn = new JButton("Build Directed Graph");

	private JLabel classToRecompileLabel = new JLabel("Class to recompile:");
	private JTextField classToRecompile = new JTextField(15);
	private JButton topologicalOrderBtn = new JButton("Topological Order");

	private JTextArea recompilationOrder = new JTextArea();

	/**
	 * This method creates the GUI.
	 */
	CDGView() {
		this.setTitle("Class Dependency Graph");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);// centers window on screen

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);

		// master panel
		JPanel panel = new JPanel();

		// creates top panel
		JPanel topPanel = new JPanel(new GridBagLayout());
		// adds border
		topPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ""));
		// sets top panel size
		topPanel.setPreferredSize(new Dimension(525, 90));

		// add components to top panel
		c.gridy = 0;
		c.gridx = 0;
		topPanel.add(inputFileNameLabel, c);

		c.gridy = 0;
		c.gridx = 1;
		topPanel.add(inputFileName, c);

		c.gridy = 0;
		c.gridx = 2;
		topPanel.add(buildDirectedGraphBtn, c);

		c.gridy = 1;
		c.gridx = 0;
		topPanel.add(classToRecompileLabel, c);

		c.gridy = 1;
		c.gridx = 1;
		topPanel.add(classToRecompile, c);

		c.gridy = 1;
		c.gridx = 2;
		recompilationOrder.setBorder(null);
		topPanel.add(topologicalOrderBtn, c);

		// creates bottom panel
		JPanel btmPanel = new JPanel();
		// creates border with label
		btmPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Recompilation Order"));
		btmPanel.setBackground(Color.WHITE); // makes background white
		// sets bottom panel size
		btmPanel.setPreferredSize(new Dimension(525, 160));
		// makes output text box uneditable
		recompilationOrder.setEditable(false);

		// add components to bottom panel
		btmPanel.add(recompilationOrder, c);

		// adds both panels to the master panel
		panel.add(topPanel);
		panel.add(btmPanel);
		this.add(panel); // adds master panel to frame
	}

	/**
	 * This method returns the text inputed into the "Input file name" text box.
	 * 
	 * @return the String inputed in the "Input file name" text box
	 */
	public String getFileName() {
		return inputFileName.getText();
	}

	/**
	 * This method returns the text inputed into the "Class to recompile" text
	 * box.
	 * 
	 * @return the String inputed in the "Class to recompile" text box
	 */
	public String getClassToRecompile() {
		return classToRecompile.getText();
	}

	/**
	 * This method changes the text in the "Recompilation Order" text area.
	 * 
	 * @param textMessage
	 *            the String to be put in the "Recompilation Order" text area.
	 */
	public void setRecompilationOrder(String textMessage) {
		recompilationOrder.setText(textMessage);
	}
	
	/**
	 * This method listens for a user to press the "Build Directed Graph" button
	 * and then executes an action listener method in the controller
	 * 
	 * @param listenForButton
	 */
	void addDirectedGraphListener(ActionListener listenForButton) {
		buildDirectedGraphBtn.addActionListener(listenForButton);
	}

	/**
	 * This method listens for a user to press the "Topological Order" button
	 * and then executes an action listener method in the controller
	 * 
	 * @param listenForButton
	 */
	void addTopologicalOrderListener(ActionListener listenForButton) {
		topologicalOrderBtn.addActionListener(listenForButton);
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
