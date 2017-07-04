package io.github.jameshiegel;

import java.util.ArrayList;

public class SeaPort extends Thing {
	// instance variables
	protected ArrayList<Dock> docks = new ArrayList<Dock>();
	// list of ships waiting to dock
	protected ArrayList<Ship> que = new ArrayList<Ship>();
	// list of all ships at this port
	protected ArrayList<Ship> ships = new ArrayList<Ship>();
	// list of people with skills at this port
	protected ArrayList<Person> persons = new ArrayList<Person>();

	// constructors
	public SeaPort() {
		super();
	} // end constructor

	public ArrayList<Dock> getDocks() {
		return docks;
	} // end method getDocks

	public ArrayList<Ship> getQue() {
		return que;
	} // end method getQue

	public ArrayList<Ship> getShips() {
		return ships;
	} // end method getShips

	public ArrayList<Person> getPersons() {
		return persons;
	} // end method getPersons

	@Override
	public String toString() {
		String st = "Port: " + super.toString();
		return st;
	} // end method toString

} // end class SeaPort
