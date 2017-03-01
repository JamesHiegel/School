package io.github.jameshiegel;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

//James Hiegel, CMSC 350, Spring 2017, Project 4
/**
 * This class creates and displays the graphic user interface, and provides
 * methods that return the "Input file name" and "Class to recompile" text
 * boxes, change the "Recompilation order" text box, action listeners for the
 * "Build Directed Graph" and "Topological Order" buttons, and a pop up window.
 */
public class CDGView {
	
	CDGView () {
		
	}
	
	/**
	 * This method returns the text inputed into the "Input file name" text box.
	 * 
	 * @return the String inputed in the "Input file name" text box
	 */
	public String getFileName() {
		return "test getFileName()";
	}
	
	/**
	 * This method returns the text inputed into the "Class to recompile" text box.
	 * 
	 * @return the String inputed in the "Class to recompile" text box
	 */
	public String getClassToRecompile() {
		return "test getClassToRecompile()";
	}
	
	/**
	 * This method listens for a user to press the "Build Directed Graph" button and then executes an
	 * action listener method in the controller
	 * 
	 * @param listenForButton
	 */
	void addDirectedGraphListener(ActionListener listenForButton) {
		buildDirectedGraphBtn.addActionListener(listenForButton);
	}
	
	/**
	 * This method listens for a user to press the "Topological Order" button and then executes an
	 * action listener method in the controller
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
