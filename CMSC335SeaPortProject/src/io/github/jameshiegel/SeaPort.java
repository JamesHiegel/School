package io.github.jameshiegel;

import java.util.ArrayList;

public class SeaPort extends Thing {
	// instance variables
	private ArrayList<Dock> docks = new ArrayList<Dock>();
	// the list of ships waiting to dock
	private ArrayList<Ship> que = new ArrayList<Ship>();
	// a list of all the ships at this port
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	// people with skills at this port
	private ArrayList<Person> persons = new ArrayList<Person>();

	// constructors
	public SeaPort(int index, String name, int parent, ArrayList<Dock> docks, ArrayList<Ship> que,
			ArrayList<Ship> ships, ArrayList<Person> persons) {
		super(index, name, parent);
		this.docks = docks;
		this.que = que;
		this.ships = ships;
		this.persons = persons;
	}

	//TODO Read data from a text file using JFileChooser
	//TODO Create instances of classes from loaded data
	//TODO Create multi-tree
	//TODO Organize created instances into data structures which can be sorted
	//TODO Present data structure contents in GUI with buttons
	//TODO Implement search function on the various fields in each class
	
	
	// methods
	public ArrayList<Dock> getDocks() {
		return docks;
	}

	public void setDocks(ArrayList<Dock> docks) {
		this.docks = docks;
	}

	public ArrayList<Ship> getQue() {
		return que;
	}

	public void setQue(ArrayList<Ship> que) {
		this.que = que;
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		String st = "\n\nSeaPort: " + super.toString();
		for (Dock md : docks)
			st += "\n" + md;
		st += "\n\n --- List of all ships in que:";
		for (Ship ms : que)
			st += "\n > " + ms;
		st += "\n\n --- List of all ships:";
		for (Ship ms : ships)
			st += "\n > " + ms;
		st += "\n\n --- List of all persons:";
		for (Person mp : persons)
			st += "\n > " + mp;
		return st;
	}// end method toString

}
