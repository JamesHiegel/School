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
				theModel.loadFile();
				theView.setTextView(theModel.getWorld());
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
			//SeaPortProgramView.appendLog("Search button pressed. Search terms: " + theView.getSearchTerm()
			//		+ ", search type: " + theView.getSearchType());
			String text = null;
			// TODO pass search terms and search type to theModel
			text = theModel.searchWorld(theView.getSearchTerm(), theView.getSearchType());
			// TODO display result from theModel on theView
			theView.setSearchResults(text);
		} // end method actionPerformed
	} // end class loadFileListener

} // end class SeaPortProgramController
