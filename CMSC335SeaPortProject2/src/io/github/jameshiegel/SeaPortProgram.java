package io.github.jameshiegel;

//File: SeaPortProgram.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: Simulates some aspects of a number of Sea Ports.

public class SeaPortProgram {

	public static void main(String[] args) {
		// instantiates the View and Model
		SeaPortProgramView theView = new SeaPortProgramView();
		SeaPortProgramModel theModel = new SeaPortProgramModel();
		// instantiates the Controller and passes the references to the View and
		// Model
		@SuppressWarnings("unused")
		SeaPortProgramController theController = new SeaPortProgramController(theView, theModel);
		// shows the GUI
		theView.setVisible(true);
	} // end method main

} // end class SeaPortProgram
