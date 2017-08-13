package io.github.jameshiegel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

//File: SeaPortProgramView.java
//Date: 04 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: 

public class SeaPortProgramModel {
	// instance variables
	private FileFilter filter = new FileNameExtensionFilter("Text File", "txt");
	private World world = null;
	private JPanel jobStatusPane = new JPanel();

	// constructor
	public SeaPortProgramModel(JPanel jobStatusPane) {
		this.jobStatusPane = jobStatusPane;
	}

	// methods
	/**
	 * Displays a pop up using JFileChooser where a user can navigate to and
	 * select a ".txt" data file to load. The file is passed line by line to the
	 * World.process method for parsing and creation of the multi-tree. Throws a
	 * FileNotFoundException if the file can't be found after selection by
	 * JFileChooser.
	 */
	public void loadFile() throws FileNotFoundException {
		world = new World(jobStatusPane);
		JFileChooser fc = new JFileChooser(".");
		Scanner sc = null;
		String st = "";
		File file = null;
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		} // end if
		try {
			sc = new Scanner(new BufferedReader(new FileReader(file)));
			while (sc.hasNextLine()) {
				st = sc.nextLine().trim();
				// ignores comment lines and blank lines
				if (!st.startsWith("//") && !st.equals("")) {
					world.process(st);
				} // end if
			} // end while
		} finally {
			sc.close();
		} // end try-finally
	} // end method loadFile

	/**
	 * This method returns a String output showing all ports, docks, ships and
	 * persons in the world.
	 * 
	 * @return String output showing all ports, docks, ships and persons in the
	 *         world.
	 */
	public String getWorld() {
		return world.toString();
	} // end method getWorld

	/**
	 * This method returns a String showing objects that match the search term
	 * and search type.
	 * 
	 * @param term
	 *            a String to search for
	 * @param type
	 *            the selected field to search in
	 * @return String showing objects that match the search term and search
	 *         type.
	 */
	public String searchWorld(String term, String type) {
		return world.search(term, type);
	} // end method searchWorld

	/**
	 * This method returns a String showing objects sorted by type from largest
	 * to smallest.
	 * 
	 * @param sortType
	 *            a String to sort by
	 * @return
	 * 
	 * @return String listing objects in sorted order
	 */
	public String sortWorld(String sortType) {
		return world.sort(sortType);
	} // end method sortWorld

	/**
	 * Returns a JTree for display in the GUI.
	 * 
	 * @return the JTree to be displayed.
	 */
	public JTree getTree() {
		return world.getTree();
	} // end method getTree

} // end class SeaPortProgramModel
