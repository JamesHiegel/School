package io.github.jameshiegel;

//File: Dock.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: A location where a Ship can dock at a SeaPort.

public class Dock extends Thing {
	// instance variables
	protected Ship ship = null;

	// constructors
	public Dock() {
		super();
	} // end constructor

	// methods
	public Ship getShip() {
		return ship;
	} // end method getShip

	@Override
	public String toString() {
		String st = "Dock: " + super.toString();
		st += "Ship: " + ship.toString();
		return st;
	} // end method toString
	
} // end class Dock
