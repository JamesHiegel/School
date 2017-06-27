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

}
