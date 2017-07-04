package io.github.jameshiegel;

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
		String st = "Passenger Ship: " + super.toString();
		return st;
	} // end method toString
}
