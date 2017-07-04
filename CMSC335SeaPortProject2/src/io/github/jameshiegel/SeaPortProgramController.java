package io.github.jameshiegel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		this.theView.loadFileBtnListener(new loadFileListener());
		this.theView.searchBtnListener(new searchListener());
	} // end SeaPortProgramController constructor

	class loadFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theView.appendLog("Load File button pressed.");
		} // end method actionPerformed
	} // end class loadFileListener

	class searchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theView.appendLog("Search button pressed. Search terms: " + theView.getSearchTerm() + ", search type: "
					+ theView.getSearchType());
		} // end method actionPerformed
	} // end class loadFileListener

} // end class SeaPortProgramController
