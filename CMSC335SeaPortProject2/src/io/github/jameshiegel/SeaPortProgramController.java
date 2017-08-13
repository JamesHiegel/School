package io.github.jameshiegel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

//File: SeaPortProgramController.java
//Date: 04 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
/*Purpose: Creates instances of the theView, theModel and passes them to the Controller.  
 * Calls the appropriate method in theModel when an actionlistener is triggered in theView.
 */

public class SeaPortProgramController {
	// instance variables
	private SeaPortProgramView theView;
	private SeaPortProgramModel theModel;

	// constructors
	public SeaPortProgramController(SeaPortProgramView theView, SeaPortProgramModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		// actionlisteners
		this.theView.loadFileBtnListener(new loadFileListener());
		this.theView.searchBtnListener(new searchListener());
		this.theView.sortBtnListener(new sortListener());
	} // end SeaPortProgramController constructor

	/**
	 * ActionListener for the "Load File" button that calls the
	 * SeaPortProgramModel class to load a data file. Then passes a String from
	 * the SeaPortProgramModel class that lists all the ports, docks, ships and
	 * persons in the world to the SeaPortProgramView class for display.
	 */
	class loadFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SeaPortProgramView.appendLog("Load File button pressed.");

			try {
				// parses the selected file
				theModel.loadFile();
				// passes a String showing the world contents to the GUI
				theView.setTextView(theModel.getWorld());
				// passes the JTree from the model to the GUI to display data
				theView.setTreeView(theModel.getTree());
			} catch (FileNotFoundException e1) {
				theView.displayErrorMessage("File not found!");
			}
		} // end method actionPerformed
	} // end class loadFileListener

	/**
	 * ActionListener for the "Search" button that passes the search term and
	 * search type from the SeaPortProgramView class to the SeaPortProgramModel
	 * class for processing. Then passes the resulting String from the
	 * SeaPortProgramModel class to the SeaPortProgramView class for display.
	 */
	class searchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// SeaPortProgramView.appendLog("Search button pressed. Search
			// terms: " + theView.getSearchTerm()
			// + ", search type: " + theView.getSearchType());
			String text = null;
			text = theModel.searchWorld(theView.getSearchTerm(), theView.getSearchType());
			theView.setSearchResults(text);
		} // end method actionPerformed
	} // end class loadFileListener

	/**
	 * ActionListener for the "Sort" button that passes the search term and sort
	 * type from the SeaPortProgramView class to the SeaPortProgramModel class
	 * for processing. Then passes the resulting String from the
	 * SeaPortProgramModel class to the SeaPortProgramView class for display.
	 */
	class sortListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SeaPortProgramView.appendLog("Sort button pressed. Sort Type: " + theView.getSortType());
			String text = null;
			text = theModel.sortWorld(theView.getSortType());
			theView.setSearchResults(text);
		} // end method actionPerformed
	} // end class loadFileListener

} // end class SeaPortProgramController
