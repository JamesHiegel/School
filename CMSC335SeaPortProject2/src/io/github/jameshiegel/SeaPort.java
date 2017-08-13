package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SeaPort extends Thing {
	// instance variables
	protected ArrayList<Dock> docks = new ArrayList<Dock>();
	// list of ships waiting to dock
	protected ArrayList<Ship> que = new ArrayList<Ship>();
	// list of all ships at this port
	protected ArrayList<Ship> ships = new ArrayList<Ship>();
	// list of people with skills at this port
	protected ArrayList<Person> persons = new ArrayList<Person>();
	
	// list of skills at this port
	protected ArrayList<String> skills = new ArrayList<String>();
	
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

	public ArrayList<String> getSkills() {
		return skills;
	} // end method getSkills

	public void addSkills(String ns) {
		// adds skill if it is not already in the array
		if (!skills.contains(ns))
			skills.add(ns);
	} // end method setSkills

	@Override
	public String toString() {
		String st = "\n\nSeaPort: " + super.toString();
		for (Dock md : docks)
			st += "\n" + md;
		st += "\n\n --- List of all ships in que:";
		for (Ship ms : que)
			st += "\n   > " + ms;
		st += "\n\n --- List of all ships:";
		for (Ship ms : ships)
			st += "\n   > " + ms;
		st += "\n\n --- List of all persons:";
		for (Person mp : persons)
			st += "\n   > " + mp;
		st += "\n\n --- List of all skills:";
		for (String sk : skills)
			st += "\n   > " + sk;
		return st;
	} // end method toString

	public void createExecutorPools() {
		ExecutorService executorService = Executors.newFixedThreadPool(docks.size());
		//System.out.println(docks.size());
	}
	
} // end class SeaPort