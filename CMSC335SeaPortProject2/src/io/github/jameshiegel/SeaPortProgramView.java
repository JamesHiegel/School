package io.github.jameshiegel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.Border;

//File: SeaPortProgramView.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: Creates the GUI and provides actionlisteners and helper methods to retrieve form and display to the GUI.

public class SeaPortProgramView extends JFrame {
	// instance variables
	private JButton loadFileBtn = new JButton("Load File");
	private JTextField searchTerm = new JTextField(15);
	private final String[] opt = { "Name", "Index" };
	private JComboBox<String> searchType = new JComboBox<String>(opt);
	private JButton searchBtn = new JButton("Search");
	private JTree treeView = new JTree();
	private JTextArea textView = new JTextArea();
	private JTable jobStatus = new JTable();
	private JTextArea thingDetails = new JTextArea();
	private JTextArea log = new JTextArea(5, 20);

	// methods
	/**
	 * This method creates the GUI.
	 */
	public SeaPortProgramView() {
		setTitle("SeaPort Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Border blackBorder = BorderFactory.createLineBorder(Color.black);

		// create master JPanel to hold all JComponents
		JPanel pane = new JPanel(new BorderLayout());
		pane.setPreferredSize(new Dimension(1024, 768));
		// adds master panel to JFrame
		add(pane);

		// creates top panel and adds components
		JPanel topPanel = new JPanel();
		topPanel.add(loadFileBtn);
		topPanel.add(new JLabel("Search for:"));
		topPanel.add(searchTerm);
		topPanel.add(searchType);
		topPanel.add(searchBtn);
		// add topPanel to master panel
		pane.add(topPanel, BorderLayout.PAGE_START);

		// creates middle panel and uses GridLayout to keep both sides equal
		JPanel midPanel = new JPanel(new GridLayout(1, 2));

		// creates left middle panel and adds components
		JTabbedPane leftPanel = new JTabbedPane();
		// makes textView scrollable, ensures it fills the viewport
		JScrollPane textJSP = new JScrollPane(textView);
		textView.setEditable(false);
		jobStatus.setFillsViewportHeight(true);
		leftPanel.addTab("Text View", textJSP);
		// makes treeView scrollable
		JScrollPane treeJSP = new JScrollPane(treeView);
		leftPanel.addTab("Tree View", treeJSP);
		// add leftPanel to midPanel
		midPanel.add(leftPanel);

		// creates right middle panel
		JTabbedPane rightPanel = new JTabbedPane();
		// makes jobStatus scrollable and adds it to the rightPanel
		JScrollPane jobJSP = new JScrollPane(jobStatus);
		rightPanel.addTab("Job Status", jobJSP);
		// makes thingDetails scrollable
		JScrollPane detailsJSP = new JScrollPane(thingDetails);
		rightPanel.addTab("Object Details", detailsJSP);
		// add rightPanel to midPanel
		midPanel.add(rightPanel);

		// add midPanel to master panel
		pane.add(midPanel, BorderLayout.CENTER);

		// create bottom panel
		Border logBorder = BorderFactory.createTitledBorder(blackBorder, "Log");
		// makes log scrollable
		JScrollPane logJSP = new JScrollPane(log);
		log.setEditable(false);
		logJSP.setBorder(logBorder); // adds titled border
		pane.add(logJSP, BorderLayout.PAGE_END);

		this.add(pane);
		pack();
		// centers GUI on the screen
		setLocationRelativeTo(null);

	} // end method initGUI

	/**
	 * This method returns a String with the current date & time.
	 * 
	 * @return the current date & time format as dd/MM/yyyy HH:mm:ss:SS
	 */
	public String timeStamp() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS").format(new java.util.Date());
	} // end method timeStamp

	/**
	 * This method appends the log JTextArea displayed at the bottom of the GUI.
	 * Entries are time stamped before being displayed.
	 * 
	 * @param text
	 *            the String to be added to the log.
	 */
	public void appendLog(String text) {
		log.append(timeStamp() + " - " + text + "\n");
	} // end method appendLog

	/**
	 * This method returns the String in the searchTerm JTextField.
	 * 
	 * @return the String in the searchTerm JTextField
	 */
	public String getSearchTerm() {
		return searchTerm.getText();
	} // end method getSearchTerm

	/**
	 * This method returns the selected String in the searchType JComboBox.
	 * 
	 * @return the selected String in the Search Type JComboBox
	 */
	public String getSearchType() {
		return (String) searchType.getSelectedItem();
	} // end method getSearchType

	/**
	 * This method listens for a user to press the "Load File" button and then
	 * executes an action listener method in the controller
	 * 
	 * @param loadFileBtn
	 */
	void loadFileBtnListener(ActionListener listenForButton) {
		loadFileBtn.addActionListener(listenForButton);
	} // end loadFileBtn actionlistener

	/**
	 * This method listens for a user to press the "Search" button and then
	 * executes an action listener method in the controller
	 * 
	 * @param searchBtn
	 */
	void searchBtnListener(ActionListener listenForButton) {
		searchBtn.addActionListener(listenForButton);
	} // end searchBtn actionlistener

	/**
	 * This method displays an error message in a pop-up window.
	 * 
	 * @param errorMessage
	 *            the String to be displayed.
	 */
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	} // end method displayErrorMessage

} // end class SeaPortProgramView
