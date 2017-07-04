package io.github.jameshiegel;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

public class SeaPortProgramModel {

}

class Thing implements Comparable<Thing> {
	// instance variables
	protected int index = 0;
	protected String name = "";
	protected int parent = 0;

	// constructors
	public Thing() {
	} // end default constructor

	public Thing(Scanner sc) {
		if (sc.hasNext())
			name = sc.next();
		if (sc.hasNextInt())
			index = sc.nextInt();
		if (sc.hasNextInt())
			parent = sc.nextInt();
	} // end Scanner constructor

	// methods
	public int getIndex() {
		return index;
	} // end method getIndex

	public String getName() {
		return name;
	} // end method getName

	public int getParent() {
		return parent;
	} // end method getParent

	@Override
	public String toString() {
		String st = String.format("%20s %10d", name, index);
		return st;
	} // end method toString

	@Override
	public int compareTo(Thing o) {
		// TODO Auto-generated method stub
		return 0;
	} // end method compareTo

} // end class Thing

class World extends Thing {
	// instance variables
	protected ArrayList<SeaPort> ports = new ArrayList<SeaPort>();
	protected PortTime time = new PortTime();
	JTextField searchTerm;
	JComboBox<String> searchType;
	JTree treeView;
	JTextArea textView;
	JTable jobStatus;
	JTextArea log;

	// constructors
	public World() {
		super();
	} // end default constructor

	// methods
	public void process(String st) {
		System.out.println("Processing >" + st + "<");
		Scanner sc = new Scanner(st);
		if (!sc.hasNext())
			return;
		switch (sc.next()) {
		case "port":
			addPort(sc);
			break;
		case "dock":
			addDock(sc);
			break;
		case "pship":
			addPassengerShip(sc);
			break;
		case "cship":
			addCargoShip(sc);
			break;
		case "person":
			addPerson(sc);
			break;
		} // end switch
	} // end method process

	private void addPerson(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	private void addCargoShip(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	private void addPassengerShip(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	private void addDock(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	private void addPort(Scanner sc) {
		// TODO Auto-generated method stub

	} // end method addPerson

	SeaPort getSeaPortByIndex(int x) {
		for (SeaPort msp : ports)
			if (msp.index == x)
				return msp;
		return null;
	} // end method getSeaPortByIndex

	Dock getDockByIndex(int x) {
		for (SeaPort msp : ports)
			for (Dock dk : msp.docks)
				if (dk.index == x)
					return dk;
		return null;
	} // end method getDockByIndex

	Ship getShipByIndex(int x) {
		for (SeaPort msp : ports)
			for (Ship ms : msp.ships)
				if (ms.index == x)
					return ms;
		return null;
	} // end method getShipByIndex

	Person getPersonByIndex(int x) {
		for (SeaPort msp : ports)
			for (Person ps : msp.persons)
				if (ps.index == x)
					return ps;
		return null;
	} // end method getPersonByIndex

	void assignShip(Ship ms) {
		Dock md = getDockByIndex(ms.parent);
		if (md == null) {
			getSeaPortByIndex(ms.parent).ships.add(ms);
			getSeaPortByIndex(ms.parent).que.add(ms);
			return;
		}
		md.ship = ms;
		getSeaPortByIndex(md.parent).ships.add(ms);
	} // end method assignShip

	public ArrayList<SeaPort> getPorts() {
		return ports;
	} // end method getPorts

	public PortTime getTime() {
		return time;
	} // end method getTime

	@Override
	public String toString() {
		return ">>>>> the World:";
	} // end method toString

} // end class World

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
