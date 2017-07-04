package io.github.jameshiegel;

//File: PassengerShip.java
//Date: 03 July 2017
//Author: James Hiegel
//Class: UMUC CMSC335 XXXX, Summer 2017
//Purpose: Simulates a passenger ship.

public class PassengerShip extends Ship {
	// instance variables
	protected int numberOfOccupiedRooms = 0;
	protected int numberOfPassengers = 0;
	protected int numberOfRooms = 0;

	// constructors
	public PassengerShip() {
		super();
	} // end constructor

	// methods
	public int getNumberOfOccupiedRooms() {
		return numberOfOccupiedRooms;
	} // end method getNumberOfOccupiedRooms

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	} // end method getNumberOfPassengers

	public int getNumberOfRooms() {
		return numberOfRooms;
	} // end method getNumberOfRooms

	@Override
	public String toString() {
		String st = "Passenger ship: " + super.toString();
		if (jobs.size() == 0)
			return st;
		for (Job mj : jobs)
			st += "\n       - " + mj;
		return st;
	} // end method toString

} // end class PassengerShip
