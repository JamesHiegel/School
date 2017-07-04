package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Scanner;

class SeaPort extends Thing {
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
	} // end default constructor
	
	public SeaPort(Scanner sc) {
		super(sc);
	} // end Scanner constructor

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
		String st = "\n\nSeaPort: " + super.toString();
		for (Dock md : docks)
			st += "\n" + md;
		st += "\n --- List of all ships in que:";
		for (Ship ms : que)
			st += "\n   > " + ms;
		st += "\n --- List of all ships:";
		for (Ship ms : ships)
			st += "\n   > " + ms;
		st += "\n --- List of all persons:";
		for (Person mp : persons)
			st += "\n   > " + mp;
		return st;
	} // end method toString

} // end class SeaPort