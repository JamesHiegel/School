package io.github.jameshiegel;

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
		return st;
	} // end method toString
	
} // end class Dock
