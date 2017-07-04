package io.github.jameshiegel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.Border;

//File: SeaPortProgram.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: Simulates some aspects of a number of Sea Ports.

public class SeaPortProgram extends JFrame {
	// instance variables
	protected JButton loadFileBtn = new JButton("Load File");
	protected JTextField searchTerm = new JTextField(15);
	private final String[] opt = { "Name", "Index"};
	protected JComboBox<String> searchType = new JComboBox<String>(opt);
	protected JButton searchBtn = new JButton("Search");

	protected JTree treeView = new JTree();
	protected JTextArea textView = new JTextArea();

	protected JTable jobStatus = new JTable();

	protected JTextArea log = new JTextArea("Log", 5, 20);

	// constructors
	public SeaPortProgram() {
		initGUI();

		World world = new World();
		log.setText(world.timeStamp() + " - World created.");

	} // end constructor

	// methods
	public void initGUI() {
		setTitle("SeaPort Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Border blackBorder = BorderFactory.createLineBorder(Color.black);

		// create JPanel to hold onscreen components
		JPanel pane = new JPanel(new BorderLayout());
		pane.setPreferredSize(new Dimension(1024, 768));
		add(pane);

		// creates top panel and adds components
		JPanel topPanel = new JPanel();
		topPanel.add(loadFileBtn);
		topPanel.add(new JLabel("Search for:"));
		topPanel.add(searchTerm);
		topPanel.add(searchType);
		topPanel.add(searchBtn);
		pane.add(topPanel, BorderLayout.PAGE_START);

		// creates middle panel
		JPanel midPanel = new JPanel(new GridLayout(1, 2));
		// creates left middle panel
		JTabbedPane leftPanel = new JTabbedPane();
		// makes textView scrollable
		JScrollPane textJSP = new JScrollPane(textView);
		textView.setEditable(false);
		leftPanel.addTab("Text View", textJSP);
		// makes treeView scrollable
		JScrollPane treeJSP = new JScrollPane(treeView);
		leftPanel.addTab("Tree View", treeJSP);
		midPanel.add(leftPanel);
		// creates right middle panel
		Border jobBorder = BorderFactory.createTitledBorder(blackBorder, "Job Status");
		// makes jobStatus scrollable and ensures it fills the pane
		JScrollPane jobJSP = new JScrollPane(jobStatus);
		jobStatus.setFillsViewportHeight(true);
		jobJSP.setBorder(jobBorder); // adds titled border
		midPanel.add(jobJSP);
		pane.add(midPanel, BorderLayout.CENTER);

		// create bottom panel
		Border logBorder = BorderFactory.createTitledBorder(blackBorder, "Log");
		// makes log scrollable
		JScrollPane logJSP = new JScrollPane(log);
		log.setEditable(false);
		logJSP.setBorder(logBorder); // adds titled border
		pane.add(logJSP, BorderLayout.PAGE_END);

		// displays GUI centered on the screen
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		// instance variables
		SeaPortProgram spp = new SeaPortProgram();
	} // end method main

} // end class SeaPortProgram
